package week_three;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";
    private static final String ANIMAL_TABLE = "CREATE TABLE a(id integer PRIMARY KEY, " +
            "name VARCHAR(20), age integer, animal_type_id integer)";
    private static final String ANIMAL_TYPE_ID = "CREATE TABLE s(id integer PRIMARY KEY, type VARCHAR(20))";

    private static final int CAT = 1;
    private static final int DOG = 2;
    private static final int FISH = 3;

    private Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
    }

    public void createTable(String tableName) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = connection();

            if (tableName.equals("animal"))
                preparedStatement = connection.prepareStatement(ANIMAL_TABLE);
            else
                preparedStatement = connection.prepareStatement(ANIMAL_TYPE_ID);

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllTwo(connection, preparedStatement);
        }
    }

    public boolean add(Animal animal) {
        Connection connection = null;
        PreparedStatement add = null;

        try {
            connection = connection();
            add = connection.prepareStatement("INSERT INTO animal VALUES(?, ?, ?, ?)");

            add.setInt(1, (int) animal.getId());
            add.setString(2, animal.getName());
            add.setInt(3, animal.getAge());

            if (animal instanceof Cat)
                add.setInt(4, CAT);
            else if (animal instanceof Dog)
                add.setInt(4, DOG);
            else
                add.setInt(4, FISH);
            add.execute();

        } catch (Exception e) {
            return false;
        } finally {
            closeAllTwo(connection, add);
        }

        return true;
    }

    public boolean remove(long animalID) {
        Connection connection = null;
        PreparedStatement del = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connection();
            preparedStatement = connection.prepareStatement("SELECT id FROM animal");
            resultSet = preparedStatement.executeQuery();

            ArrayList<Long> allID = new ArrayList<>();
            while (resultSet.next()) {
                allID.add(resultSet.getLong("id"));
            }
            if (!allID.contains(animalID)) {
                return false;
            }

            del = connection.prepareStatement("DELETE FROM animal WHERE id = ?");
            del.setInt(1, (int) animalID);
            del.execute();

            del.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (del != null) {
                try {
                    resultSet.close();
                    preparedStatement.close();
                    del.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    public Animal findById(long animalID) {
        Connection connection = null;
        PreparedStatement get = null;
        ResultSet resultSet = null;

        try {
            connection = connection();
            get = connection.prepareStatement("SELECT name, age, animal_type_id, id FROM animal WHERE id = ?");

            get.setInt(1, (int) animalID);
            resultSet = get.executeQuery();
            resultSet.next();

            return returnedAnimal(resultSet);
        } catch (Exception e) {
            System.out.println("Animals with such ID does not exist!");
        } finally {
            closeAll(resultSet, get, connection);
        }

        return null;
    }

    public boolean update(Animal animal) {
        Connection connection = null;
        PreparedStatement upd = null;

        List<Animal> list = findAll();
        List<Long> list1 = new ArrayList<>();
        for (Animal a : list) {
            list1.add(a.getId());
        }
        if (!list1.contains(animal.getId()))
            return false;

        try {
            connection = connection();
            upd = connection.prepareStatement("UPDATE animal SET name = ?, age = ? WHERE id = ?");

            upd.setString(1, animal.getName());
            upd.setInt(2, animal.getAge());
            upd.setLong(3, animal.getId());
            upd.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAllTwo(connection, upd);
        }
        return true;
    }

    public List<Animal> findAll() {
        List<Animal> result = new ArrayList<Animal>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connection();

            preparedStatement = connection.prepareStatement("SELECT * FROM animal");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                result.add(returnedAnimal(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }
        return result;
    }

    public List<Animal> findByType(String type) {
        List<Animal> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = connection();

            preparedStatement = connection.prepareStatement("SELECT name, age, id FROM animal WHERE animal_type_id = ?");
            if (type.toLowerCase().equals("cat"))
                preparedStatement.setInt(1, CAT);
            else if (type.toLowerCase().equals("dog"))
                preparedStatement.setInt(1, DOG);
            else
                preparedStatement.setInt(1, FISH);

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (type.toLowerCase().equals("cat")) {
                    result.add(new Cat(Long.parseLong(resultSet.getString("id")),
                            resultSet.getString("name"), Integer.parseInt(resultSet.getString("age"))));
                } else if (type.toLowerCase().equals("dog")) {
                    result.add(new Dog(Long.parseLong(resultSet.getString("id")),
                            resultSet.getString("name"), Integer.parseInt(resultSet.getString("age"))));
                } else {
                    result.add(new Fish(Long.parseLong(resultSet.getString("id")),
                            resultSet.getString("name"), Integer.parseInt(resultSet.getString("age"))));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(resultSet, preparedStatement, connection);
        }
        return result;
    }

    private static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeAllTwo(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Animal returnedAnimal (ResultSet resultSet) throws SQLException {
        if (Integer.parseInt(resultSet.getString("animal_type_id")) == CAT) {
            return new Cat(Long.parseLong(resultSet.getString("id")),
                    resultSet.getString("name"), Integer.parseInt(resultSet.getString("age")));
        } else if (Integer.parseInt(resultSet.getString("animal_type_id")) == DOG) {
            return new Dog(Long.parseLong(resultSet.getString("id")),
                    resultSet.getString("name"), Integer.parseInt(resultSet.getString("age")));
        } else {
            return new Fish(Long.parseLong(resultSet.getString("id")),
                    resultSet.getString("name"), Integer.parseInt(resultSet.getString("age")));
        }
    }
}

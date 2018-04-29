package week_three;

import java.io.*;

public class UserSerialization {
	public void serialization(Animal animal) {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Animal.ser")));
            out.flush();
            out.writeObject(animal);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Animal deserialization(String fileName) {
        ObjectInputStream in = null;
        Animal restAnimal = null;

        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            restAnimal = (Animal) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return restAnimal;
    }
}

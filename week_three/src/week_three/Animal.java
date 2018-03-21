package week_three;

// Task 1.

public abstract class Animal {
	private static int countAnimals;
    private String name;
    private int age;

    Animal(String name, int age) {
        countAnimals++;
        this.name = name;
        this.age = age;
    }

    public abstract void voice();

    String getName() {
        return this.name;
    }

    int getAge(){
        return this.age;
    }

    int getCountAnimals() {
        return countAnimals;
    }
}

package week_three;

import java.io.Serializable;

// Task 1.

public abstract class Animal implements Serializable{
	private static int countAnimals;
    private String name;
    private int age;

    Animal(String name, int age) {
        countAnimals++;
        this.name = name;
        this.age = age;
    }

    public abstract void voice();
    
//	Task 3. (Module 3.1)
    
    public abstract void dyingVoice();

    String getName() {
        return this.name;
    }

    int getAge(){
        return this.age;
    }

    static int getCountAnimals() {
        return countAnimals;
    }
    
//  Task 1. (Module 3.1)

    @Override
    public boolean equals(Object o) {
    	if (this == o) return true;
    	if (o == null || getClass() != o.getClass()) return false;

    	Animal animal = (Animal) o;

    	if (age != animal.age) return false;
    	if (!(this.getClass().getSimpleName().equals(animal.getClass().getSimpleName()))) return false;
    	return name != null ? name.equals(animal.name) : animal.name == null;
    }

//  Task 2. (Module 3.1)

    @Override
    public String toString() {
		return "Animal{" +
				"type='" + this.getClass().getSimpleName() + '\'' +
				", name='" + name + '\'' +
				", age=" + age +
				'}';
	}

    
//	Task 3. (Module 3.1)
    
    @Override
    public void finalize() throws Throwable {
    	dyingVoice();
    }
}

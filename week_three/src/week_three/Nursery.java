package week_three;

import java.util.ArrayList;

// Task 4.

public class Nursery {
	private ArrayList<Animal> nursery = new ArrayList<>();

    public void addToNursery(Animal animal) {
        nursery.add(animal);
    }

    public ArrayList<Animal> getPet(String type, int start, int finish) {
        ArrayList<Animal> expectedPets = new ArrayList<>();
        String typeAnimal;

        for (Animal a: nursery) {
            typeAnimal = a.getClass().getSimpleName().toLowerCase();
            if (typeAnimal.equals(type.toLowerCase()) && (a.getAge() >= start && a.getAge() <= finish))
            	expectedPets.add(a);
        }
        if (expectedPets.size() == 0)
            System.out.println("This pet is not present.");

        return expectedPets;
    }
}

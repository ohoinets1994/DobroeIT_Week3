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
            if (a instanceof Cat)
                typeAnimal = "cat";
            else
                typeAnimal = "dog";
            if (typeAnimal.equals(type) && (a.getAge() >= start && a.getAge() <= finish))
                expectedPets.add(a);
//            typeAnimal = a.getClass().toString().substring(6, a.getClass().toString().length()).toLowerCase();
//            if (typeAnimal.equals(type) && (a.getAge() >= start && a.getAge() <= finish))
//                nurseryAnimal.add(a);
        }
        if (expectedPets.size() == 0)
            System.out.println("This pet is not present.");

        return expectedPets;
    }
}

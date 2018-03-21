package week_three;

import java.util.ArrayList;

// 4. Создать класс питомник, который будет хранить массив животных.
//	  Реализовать метод по добавлению животных в питомник, а также по получению всех животных
//    по типу и диапазону лет включительно(метод должен принимать три аргумента - тип животного,
//    число, соответствующее старту диапазона и число, соответствующее его концу).

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

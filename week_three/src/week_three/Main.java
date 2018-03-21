package week_three;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//  Task 2.
	        ArrayList<Animal> list = new ArrayList<>();
	        list.add(new Cat("Bella", 0));
	        list.add(new Cat("CoCo", 6));
	        list.add(new Cat("Oscar", 10));
	        list.add(new Dog("Liza", 2));
	        list.add(new Dog("Jaccck", 4));
	        list.add(new Dog("Spike", 7));

	        System.out.println("All animals - " + list.get(0).getCountAnimals());

	        for (Animal pet: list) {
	            if (pet instanceof Cat) {
	                System.out.print("Hello! I`m cat, my name is - " + pet.getName() +
	                        " and i`m " + pet.getAge() + " years old." + " ");
	                pet.voice();
	            } else {
	                System.out.print("Hello! i`m dog, my name is - " + pet.getName() +
	                        " and i`m " + pet.getAge() + " years old." + " ");
	                pet.voice();
	            }
	        }

	        deleteAnimals(list);

	        for (Animal pet : list) {
	            if (pet instanceof Cat)
	                System.out.println("- i`m cat, my name is - " + pet.getName() +
	                        " and i`m " + pet.getAge() + " years old.");
	            else
	                System.out.println("- i`m dog, my name is - " + pet.getName() +
	                        " and i`m " + pet.getAge() + " years old.");
	        }

	        System.out.println();
	        Nursery nursery = new Nursery();
	        nursery.addToNursery(new Cat("Ignat", 5));
	        nursery.addToNursery(new Cat("Ivan", 8));
	        nursery.addToNursery(new Dog("Spike", 5));
	        nursery.addToNursery(new Dog("Ivan", 3));
	        nursery.addToNursery(new Dog("Ivan", 9));

	        ArrayList<Animal> expectedPets = nursery.getPet("dog", 3,8);

	        if (expectedPets.size() == 0)
	            System.out.println("sorry");
	        else {
	            for (Animal s: expectedPets) {
	                System.out.println(s.getName());
	            }
	        }

	        int[] a = {5,3,7,3,1,9,2,9,0,4,9};
	        int [] newArr = changeArray(a);
	        for (int i : newArr) {
	            System.out.print(i + " ");
	        }
	    }

//  Task 3.
	    private static void deleteAnimals(ArrayList<Animal> list) {
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i) instanceof Cat) {
	                if (list.get(i).getAge() < 1 || list.get(i).getAge() > 8) {
	                    list.remove(i);
	                    i--;
	                }
	            } else if (list.get(i) instanceof Dog) {
	                if (checkConsonantLetter(list.get(i).getName()) > 4) {
	                    list.remove(i);
	                    i--;
	                }
	            }
	        }
	    }

	    private static int checkConsonantLetter(String dogName) {
	        int countConsonantLetter = 0;
	        char[] chars = dogName.toLowerCase().toCharArray();
	        char[] consonant = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l',
	                'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z', 'w'};

	        for (char c : chars) {
	            for (char v : consonant) {
	                if (v == c) {
	                    countConsonantLetter++;
	                    break;
	                }
	            }
	        }
	        return countConsonantLetter;
	    }

//  Task 5.
	    private static int[] changeArray(int[] array) {
	        int tmp = 0;
	        int size = 0;
	        int[] newArray;

	        for (int i : array) {
	            if (i < 0 || i > 100) {
	                System.out.println("Input array values cannot be less than 0" +
	                        " or greater than 100. Check your array again: ");
	                return array;
	            }
	            if (i > size)
	                size = i;
	        }
	        newArray = new int[size + 1];

	        for (int i : array) {
	            tmp = 0;
	            for (int j : array) {
	                if (j == i)
	                    tmp++;
	            }
	            newArray[i] = tmp;
	        }
	        return newArray;
	    }

}

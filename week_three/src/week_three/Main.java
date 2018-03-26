package week_three;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Animal> list = new ArrayList<>();
		list.add(new Cat("Bella", 0));
		list.add(new Cat("CoCo", 6));
		list.add(new Cat("Oscar", 10));
		list.add(new Dog("Liza", 2));
		list.add(new Fish("Jaccck", 4));
		list.add(new Fish("Spike", 7));
		list.add(new Fish("Spike", 7));
		list.add(new Dog("Spike", 7));
		list.add(new Dog("Spike", 7));

		for (Animal animal : list) {
			try {
				animal.voice();				
			} catch (UnsupportedOperationException e) {}
		}
		
		System.out.println(Fish.getCount());
		System.out.println(Animal.getCountAnimals());
		System.out.println(getClassName(list.get(0)));
		
		for (int i = 0; i < 300000; i++) {
			new Cat("Bars", 1);
			new Dog("Spike", 2);
		}
//		System.gc();
	}
	
//  Task 4. (Module 3.1)

	private static String getClassName(Object o) {
		return o.getClass().getSimpleName();
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
		char[] consonant = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm',
				'n', 'p', 'q', 'r', 's', 't', 'v', 'x', 'z', 'w' };

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
			newArray[i]++;
		}
		return newArray;
	}
}

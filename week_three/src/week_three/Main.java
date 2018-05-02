package week_three;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Animal> list = new ArrayList<>();
		list.add(new Cat(1, "Bella", 0));
		list.add(new Cat(1, "CoCo", 6));
		list.add(new Cat(1, "Oscar", 10));
		list.add(new Dog(1, "Liza", 2));
		list.add(new Fish(1, "Jaccck", 4));
		list.add(new Fish(1, "Spike", 7));
		list.add(new Fish(1, "Spike", 7));
		list.add(new Dog(1, "Spike", 7));
		list.add(new Dog(1, "Spike", 7));

		int count = 0;
		for (Animal animal : list) {
			try {
				animal.voice();				
			} catch (UnsupportedOperationException e) {
				count++;
			}
		}
		System.out.println(count);
		System.out.println(Animal.getCountAnimals());
		System.out.println(getClassName(list.get(0)));
		
//		for (int i = 0; i < 300000; i++) {
//			new Cat(1, "Bars", 1);
//			new Dog(1, "Spike", 2);
//		}
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

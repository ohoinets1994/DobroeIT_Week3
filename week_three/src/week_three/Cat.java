package week_three;

public class Cat extends Animal {
	
	Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("Miau");
    }
}

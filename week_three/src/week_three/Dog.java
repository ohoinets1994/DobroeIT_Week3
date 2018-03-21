package week_three;

public class Dog extends Animal{

	Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("√‡‚");
    }
}

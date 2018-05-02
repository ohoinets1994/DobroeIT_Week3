package week_three;

public class Dog extends Animal{

	Dog(long id, String name, int age) {
        super(id, name, age);
    }

    @Override
    public void voice() {
        System.out.println("Woof");
    }
    
    @Override
	public void dyingVoice() {
		System.out.println("Last Woof before death");
	}
}

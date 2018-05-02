package week_three;

public class Cat extends Animal {
	
	Cat(long id, String name, int age) {
        super(id, name, age);
    }


    @Override
    public void voice() {
        System.out.println("Miau");
    }
    
    @Override
	public void dyingVoice() {
		System.out.println("Last Meow before death ");
	}
}

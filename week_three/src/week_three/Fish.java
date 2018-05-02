package week_three;

//	Task 5. (Module 3.1)

public class Fish extends Animal {
	
    Fish(long id, String name, int age) {
        super(id, name, age);
    }
	
	@Override
	public void voice() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void dyingVoice() {
	}
}

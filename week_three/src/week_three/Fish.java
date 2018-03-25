package week_three;

//	Task 5. (Module 3.1)

public class Fish extends Animal {
	
    private static int count;

	Fish(String name, int age) {
        super(name, age);
    }
	
	protected static int getCount() {
        return count;
    }
	
	@Override
	public void voice() {
        count++;
		throw new UnsupportedOperationException();
	}

	@Override
	public void dyingVoice() {
	}
}

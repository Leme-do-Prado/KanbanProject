package Entities;

public class Person {
	protected String name;
	protected int shift = 8;
	
	public Person(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

	public String getName() {
		return name;
	}
}

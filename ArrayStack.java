/*
	Collaborators: Noam Ben Simon, Joshua Feigin, Max Franklin
*/

public class ArrayStack {
	
	private Character[] line;
	private int charIndex;
	
	public ArrayStack() {
		this.line = new Character[1];
		this.charIndex = -1;
	}
	
	public void push(Character character) { // pushes
		if (this.size() >= this.line.length - 1) { // stack would be full if added
			this.line = doubleIt();
		}
		this.line[++charIndex] = character; // stack would NOT be full if added, or else was already doubled (in the case it was caught above)
		return;
	}
	
	private Character[] doubleIt() {
		int newLength = line.length * 2; // doubles length of that SPECIFIC row
		Character[] longerArray = new Character[newLength]; // creates new array
		for (int i = 0; i < line.length; i++) {
			longerArray[i] = line[i]; // copy old array into new one
		}
		return longerArray; // return new
	}
	
	public Character pop() { // pops
		if (this.charIndex == -1) {
			return null;
		}
		Character popped = line[this.charIndex];
		line[this.charIndex--] = null;
		return popped;
	}
	
	public Character peek() {
		if (this.charIndex == -1) {
			return null;
		}
		return line[charIndex];
	}
	
	public int size() {
		return this.charIndex + 1;
	}
}
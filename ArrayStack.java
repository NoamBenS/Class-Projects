/*
	Collaborators: Noam Ben Simon, Joshua Feigin, Max Franklin
*/

public class ArrayStack {
	
	private char[] lines;
	private int charNumber;
	
	public ArrayStack() {
		this.lines = new char[1];
		this.charNumber = 0;
	}
	
	public void push(char character) { // pushes
		if (charNumber + 1 >= this.lines.length) { // stack would be full if added
			this.lines = doubleIt();
		}
		this.lines[++charNumber] = character; // stack would NOT be full if added, or else was already doubled (in the case it was caught above)
		return;
	}
	
	private char[] doubleIt() {
		int newLength = lines.length * 2; // doubles length of that SPECIFIC row
		char[] longerArray = new char[newLength]; // creates new array
		for (int i = 0; i < lines.length; i++) {
			longerArray[i] = lines[i]; // copy old array into new one
		}
		return longerArray; // return new
	}
	
	public char pop() { // pops
		char popped = lines[this.charNumber];
		lines[this.charNumber--] = null;
		return popped;
	}
	
	public char peek() {
		return lines[charNumber];
	}
	
	public int size() {
		return this.charNumber;
	}
}
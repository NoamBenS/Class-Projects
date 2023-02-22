import java.util.Scanner;

public class TextEditor {
	
	private ArrayStack[] text;
	private int currentIndex;
	
	public TextEditor() {
		this.text = new ArrayStack[] {new ArrayStack()};
		this.currentIndex = 0;
	}
	
	public void reverse(int Num) { // reverse the text in given line number
		ArrayStack reversed = new ArrayStack();
		while (this.text[Num].size() > 0) {
			reversed.push(this.text[Num].pop()); // pop is what decrements the counter, this.text[Num] is just pointing at the right line that you want to flip
		}
		this.text[Num] = reversed;
	}
	
	public void reverseLines() { // reverses the order of the lines
		int length = this.text.length;
		for(int i = 0; i < length/2; i++){
			int other = length - 1 - i;
			ArrayStack temp = this.text[i];
			this.text[i] = this.text[other];
			this.text[other] = temp;
		}
	}
	
	public void newLine() {
		if (currentIndex + 1 >= text.length) { // stack would be full if added
			doubleIt();
		}
		currentIndex++;
	}
	
	public void addChar(char character) {
		text[currentIndex].push(character);
	}
	
	private void doubleIt() { // must only input the SPECIFIC ROW, cannot input textEditor.length() because that will be the # of rows
		int newLength = this.text.length * 2; // doubles length of that SPECIFIC row
		ArrayStack[] longerArray = new ArrayStack[newLength]; // creates new array
		for (int i = 0; i < this.text.length; i++) {
			longerArray[i] = this.text[i]; // copy old array into new one
		}
		this.text = longerArray;
	}
	
	public void print() { // prints out the entire document, without changing the document
		for (int i = 0; i < this.text.length; i++) {
			//do thus.
		}
	}
	
}
public class TextEditor {
	
	public static void main(String[] args) {
		ArrayStack boingus = new ArrayStack();
		System.out.println(boingus.shape());
	}
	
	public void reverse(int Num) { // reverse the text in given line number
		
	}
	
	public void reverseLines() { // reverses the order of the lines
		
	}
	
	public void print() { // prints out the entire document, without changing the document
		for (int i = 0; i < this.lines.length; i++) {
			for (int j = 0; j < this.lines[i].length; j++) {
				System.out.print(lines[i][j]);
			}
			System.out.println();
		}
	}
	
}
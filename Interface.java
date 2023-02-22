import java.util.Scanner;

public class Interface {
    
    public static void main(String[] args) {
        System.out.println("Input an individual character and press enter to save it." + 
            "Enter no character for a newline, type \"stop\" to exit, type \"print\" to print everything, " + 
            "and type \"clear\" to clear the text:" + 
            "for reversing a single line, type \" reverse \". For reversing the order of the entire document, " +
            "type \"reverseLines\"");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        TextEditor te = new TextEditor();
        while (running) {
            String input = scanner.nextLine();
            switch (input) {
                case "stop":
                    running = false;
                    break;
                case "":
                    te.newLine();
                    break;
                case "print":
                    te.print();
                    break;
                case "reverse":
                    System.out.println("which line?");
                    int i = scanner.nextInt();
                    te.reverse(i);
                    break;
                case "reverseLines":
                    te.reverseLines();
                    break;
                default:
                    te.addChar(input.charAt(0));
                    break;
            }
        }
        scanner.close();
	}
    
}
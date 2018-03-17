import java.util.Scanner;

public class AscIIValue {

    public enum ProgramStatus {
        EXIT('N');

        private char value;
        private ProgramStatus(char value) {
        this.value = value;
        }

        public char value() {
            return value;
        }
    }
    public static void main(String[] args) {

        // Write a Java program to print the ascii value of a given character

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("Input a letter ");
            char letter = scan.next().charAt(0);
                
            if ((letter >= 'A' && letter<= 'Z') || (letter >= 'a' && letter <='z')) {
                    
                int asciiCode = (int) letter;
            
                System.out.println("The ASCII code of " + letter + " is: " + asciiCode);
                System.out.println("Enter Y to continue or N to exit");

                if (scan.next().charAt(0) == ProgramStatus.EXIT.value) {
                    break;
                }
            }
            else {
                System.out.println("You didn't input a letter !! Try again");
            }
        }
        scan.close();      
    }
    
}


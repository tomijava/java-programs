import java.util.Scanner;


public class AscIIValue {

    public enum ContinueOrExit { //How i should name this enum?
        EXIT('N'),
        CONTINUE('Y');
    
        private char value;
        private ContinueOrExit(char value) {
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
                    
                int ascii = (int) letter;
            
                System.out.println("The ASCII value of " + letter + " is: " + ascii);
                System.out.println("Enter Y to continue or N to exit");
                char whatToDo = scan.next().charAt(0);

                if (whatToDo == ContinueOrExit.CONTINUE.value) {
                    continue;
                }
                else if (whatToDo == ContinueOrExit.EXIT.value) {
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


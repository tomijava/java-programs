import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        /************************************************
        Write a Java program to reverse a string and 
        Write a Java program to count the letters, spaces, 
        numbers and other characters of an input string.
        *************************************************/
        
        Scanner scan = new Scanner(System.in);
        int escape = 1;
        int letters = 0;
        int numbers = 0;
        int spaces = 0;
        int othersChar = 0;
        while(escape == 1) {
            System.out.println("Input a sentence: ");
            char [] chars = scan.nextLine().toCharArray();

            for(int index = chars.length-1; index >=0; index--) {
                System.out.print(chars[index]);
            }

            System.out.print("\n"); 
            
            for(int index = chars.length-1; index >=0; index--) {
                if((chars[index] > 65 && chars[index] < 90 ) || (chars[index] > 97 && chars[index] < 122)) {
                    letters++;
                }
                else if(chars[index] > 48 && chars[index] < 57) {
                    numbers++;
                }
                else if(chars[index] == ' ') {
                    spaces++;
                }
                else {
                    othersChar++;
                }
            }
            System.out.println("Letters in sentence = " + letters);
            System.out.println("Numbers in sentence = " + numbers);
            System.out.println("Spaces in sentence = " + spaces);
            System.out.println("Others characters in sentence = " + othersChar);
            letters = 0;
            numbers = 0;
            spaces = 0;
            othersChar = 0;

            System.out.println("Input 1 to contunue or annother number to exit");
            escape = scan.nextInt();
            scan.nextLine();
        }
    scan.close();
    }
}

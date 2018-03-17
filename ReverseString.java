import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        /************************************************
        Write a Java program to reverse a string and 
        Write a Java program to count the letters, spaces,
        numbers and other characters of an input string.
        *************************************************/
        
        Scanner scan = new Scanner(System.in);
        boolean doContinue = true;
        int letterCount = 0;
        int numberCount = 0;
        int spaceCount = 0;
        int otherCharCount = 0;
        while(doContinue) {
            System.out.println("Input a sentence: ");
            char [] chars = scan.nextLine().toCharArray();

            for(int index = chars.length-1; index >=0; index--) {
                System.out.print(chars[index]);
            }

            System.out.print("\n"); 
            
            for(int index = chars.length-1; index >=0; index--) {
                if((chars[index] >= 'A' && chars[index] <= 'Z' ) || (chars[index] >= 'a' && chars[index] <= 'z')) {
                    letterCount++;
                }
                else if(chars[index] > 48 && chars[index] < 57) {
                    numberCount++;
                }
                else if(chars[index] == ' ') {
                    spaceCount++;
                }
                else {
                    otherCharCount++;
                }
            }
            System.out.println("Letters in sentence = " + letterCount);
            System.out.println("Numbers in sentence = " + numberCount);
            System.out.println("Spaces in sentence = " + spaceCount);
            System.out.println("Others characters in sentence = " + otherCharCount);
            letterCount = 0;
            numberCount = 0;
            spaceCount = 0;
            otherCharCount = 0;

            System.out.println("Input 1 to contunue or annother number to exit");
            doContinue = scan.nextInt() == 1;
        }
        scan.close();
    }
}

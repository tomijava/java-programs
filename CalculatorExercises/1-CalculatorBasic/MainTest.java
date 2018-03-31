import java.util.*;
import java.lang.*;

public class MainTest {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        
        double result = 0;

        while(true) {

            System.out.println(Calculator.getResult());

            StringBuilder input = new StringBuilder(scan.nextLine()); 

            Strings.removeWhiteSpace(input);

            if (input.toString().equals("exit")) {
                break;  
            }

            Calculator.calculation(input);
        }
    }
}

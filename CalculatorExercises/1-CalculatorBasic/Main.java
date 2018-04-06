import java.util.*;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        Calculator calculator = new Calculator();
        
        while(true) {

            System.out.println(calculator.getResult());

            String input = new String(scan.nextLine()); 

            StringHelper.removeWhiteSpace(input);

            if (input.toString().equals("exit")) {
                break;  
            }

            calculator.calculate(input);
        }
    }
}

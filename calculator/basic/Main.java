package calculator.basic;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        Calculator calculator = new Calculator();
        
        while(true) {

            System.out.println(calculator.toString());

            String input = StringHelper.removeWhitespace(scan.nextLine());

            if (input.equals("exit")) {
                break;  
            }
            calculator.calculate(input);
        }
    }
}

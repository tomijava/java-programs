import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        Calculator calculator = new Calculator();
        
        while(true) {

            System.out.println(calculator.toString(calculator.getResult()));

            String input = new String(scan.nextLine()); 

            StringHelper.removeWhitespace(input);

            if (input.toString().equals("exit")) {
                break;  
            }
            calculator.calculate(input);
        }
    }
}

package calculator.interfaces;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.*;

public class Main {

    public static String basicCalculator = "1";
    public static String moduloCalculator = "2";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String calculatorModel = "0";
        Pattern pattern = Pattern.compile("[\\+\\-\\*\\/]{1}[0-9]+");
        Calculator calculator; 

        System.out.println("Please chose calculator model");
        System.out.println("Enter 1 for basic calculator");
        System.out.println("Enter 2 for modulo calculator");

        calculatorModel = scan.nextLine();



        while(true) {
            if (calculatorModel.equals(basicCalculator)) {
                calculator = new CalculatorBasic();
                break;
            }
            else if (calculatorModel.equals(moduloCalculator)) {

                System.out.println("Enter modulo number");
                calculator = new CalculatorModulo(scan.nextInt());
                scan.nextLine();
                break;
            }
            else {
                System.out.println("Bad command");
            }
        }

        

        while(true) {

            System.out.println(calculator.toString());
            String input = StringHelper.removeWhitespace(scan.nextLine());
            Matcher matcher = pattern.matcher(input);
                        
            if (input.equals("exit")) {
                break;  
            }
            else if(matcher.matches()) {
                switch (input.charAt(0)) {
                    case '+' :
                        calculator.add(Double.parseDouble(input.substring(1)));
                        break;
                    case  '-' :
                        calculator.subtract(Double.parseDouble(input.substring(1)));
                        break;
                    case '/':
                        calculator.divide(Double.parseDouble(input.substring(1)));
                        break;
                    case '*':
                        calculator.multiply(Double.parseDouble(input.substring(1)));
                        break;
                    }       
            }
            else {
                System.out.println("Bad command");
            }
        }
        scan.close();
    }
}
 
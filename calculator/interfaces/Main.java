package calculator.interfaces;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.*;

public class Main {

    public static final String basicCalculator = "1";
    public static final String moduloCalculator = "2";
    public static final String binaryCalculator = "3";
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String calculatorModel = "0";
        Pattern pattern;
        Calculator calculator; 

        System.out.println("Please chose calculator model");
        System.out.println("Enter 1 for basic calculator");
        System.out.println("Enter 2 for modulo calculator");
        System.out.println("Enter 3 for binary calculator");

        while(true) {
            calculatorModel = scan.nextLine();

            if (calculatorModel.equals(basicCalculator)) {
                calculator = new CalculatorBasic();
                pattern = Pattern.compile("[\\+\\-\\*\\/]{1}[0-9]+");
                break;
            }
            else if (calculatorModel.equals(moduloCalculator)) {

                pattern = Pattern.compile("[\\+\\-\\*\\/]{1}[0-9]+");
                System.out.println("Enter modulo number");
                calculator = new CalculatorModulo(scan.nextInt());
                scan.nextLine();
                break;
            }
            else if (calculatorModel.equals(binaryCalculator)) {
                calculator = new CalculatorBinary();
                pattern = Pattern.compile("\\+{1}[0-1]*");
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
                    case '-' :
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
 
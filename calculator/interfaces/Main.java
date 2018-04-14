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

        System.out.println("Please chose calculator model");
        System.out.println("Enter 1 for basic calculator");
        System.out.println("Enter 2 for modulo calculator");
                    
        calculatorModel = scan.nextLine();

        if (calculatorModel.equals(basicCalculator)) {
            Calculator calculatorBasic = new CalculatorBasic();
            while(true) {
                System.out.println(calculatorBasic.toString());
                String input = StringHelper.removeWhitespace(scan.nextLine());
                Matcher matcher = pattern.matcher(input);
                        
                if (input.equals("exit")) {
                    break;  
                }
                else if(matcher.matches()) {
                    switch (input.charAt(0)) {
                        case '+' :
                            calculatorBasic.add(Double.parseDouble(input.substring(1)));
                            break;
                        case  '-' :
                            calculatorBasic.subtract(Double.parseDouble(input.substring(1)));
                            break;
                        case '/':
                            calculatorBasic.divide(Double.parseDouble(input.substring(1)));
                            break;
                        case '*':
                            calculatorBasic.multiply(Double.parseDouble(input.substring(1)));
                            break;
                    }       
                }
                else {
                    System.out.println("Bad command");
                }
            }
        }
        else if (calculatorModel.equals(moduloCalculator)) {
            System.out.println("Enter modulo number");
            Calculator calculatorModulo = new CalculatorModulo(scan.nextInt());
            scan.nextLine();
            while(true) {
                System.out.println(calculatorModulo.toString());
                String input = StringHelper.removeWhitespace(scan.nextLine());
                Matcher matcher = pattern.matcher(input);
                        
                if (input.equals("exit")) {
                    break;  
                }
                else if(matcher.matches()) {   
                    switch (input.charAt(0)) {
                        case '+':
                            calculatorModulo.add(Double.parseDouble(input.substring(1)));
                            break;
                        case '-':
                            calculatorModulo.subtract(Double.parseDouble(input.substring(1)));
                            break;
                        case '/':
                            calculatorModulo.divide(Double.parseDouble(input.substring(1)));
                            break;
                        case '*':
                            calculatorModulo.multiply(Double.parseDouble(input.substring(1)));
                            break;
                    }
                }
                else {
                    System.out.println("Bad commnad");
                }
            }
        }
    }
}
 
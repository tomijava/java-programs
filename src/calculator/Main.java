package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final String BASIC_CALCULATOR = "1";
    private static final String MODULO_CALCULATOR = "2";
    private static final String BINARY_CALCULATOR = "3";
    private static final String DATE_AND_TIME_CALCULATOR = "4";
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String calculatorModel;
        Calculator calculator ;
        CalculatorDateAndTime calculatorDateAndTime = null;

        System.out.println("Please chose calculator model");
        System.out.println("Enter 1 for basic calculator");
        System.out.println("Enter 2 for modulo calculator");
        System.out.println("Enter 3 for binary calculator");
        System.out.println("Enter 4 for Date and Time calculator");

        while(true) {
            calculatorModel = scan.nextLine();

            if (calculatorModel.equals(BASIC_CALCULATOR)) {
                calculator = new CalculatorBasic();
                break;
            }
            else if (calculatorModel.equals(MODULO_CALCULATOR)) {
                System.out.println("Enter modulo number");
                calculator = new CalculatorModulo(scan.nextInt());
                scan.nextLine();
                break;
            }
            else if (calculatorModel.equals(BINARY_CALCULATOR)) {
                calculator = new CalculatorBinary();
                break;
            }
            else if (calculatorModel.equals(DATE_AND_TIME_CALCULATOR)) {
                System.out.println("Choose your time zone");
                Zone.printAllTimeZone();
                int timeZone = scan.nextInt();
                scan.nextLine();
                for (Zone id : Zone.values()) {
                    if (id.number == timeZone) {
                        calculatorDateAndTime = new CalculatorDateAndTime(id);
                        System.out.printf("You choosed %s zone %n", id.idZone); 
                        break;
                    }
                }               
            }
            else {
                System.out.println("Bad command");
            }
        }
        while (true) {
            if (calculatorDateAndTime instanceof CalculatorDateAndTime) {
                System.out.println(calculatorDateAndTime.toString());
                String input = StringHelper.removeWhitespace(scan.nextLine());
                if (input.equals("exit")) {
                    break;  
                }
                else if (input.equals("help")) {
                    calculatorDateAndTime.printHelp();
                }
                else if (input.equals("changeCity")) {
                    Zone.printAllTimeZone();
                    System.out.println("Enter the city number");
                    while (true) {
                        int cityNumber = scan.nextInt();
                        scan.nextLine();
                        if (cityNumber >= Zone.numberOfFirstZone && cityNumber <= Zone.numberOfLastZone) {
                            for (Zone id : Zone.values()) {
                                if (id.number == cityNumber) {
                                    calculatorDateAndTime = new CalculatorDateAndTime(id);
                                    break;
                                }
                            }
                            break;
                        }
                        else {
                            System.out.println("Bad number");
                        }
                    }
                }
                else if (input.equals("whenSunday")) {
                    System.out.println(calculatorDateAndTime.whenSunday());

                }
                else if (input.matches(calculatorDateAndTime.INPUT_PATTERN_FOR_CALCULATE.pattern())) {
                    calculatorDateAndTime.calculate(input);
                }
                else if (input.matches(calculatorDateAndTime.INPUT_PATTERN_FOR_SHOW_SECONDS_SINCE.pattern())) {                                
                    calculatorDateAndTime.showSecondsSince(input);
                }
                else {
                    System.out.println("Bad command");
                    calculatorDateAndTime.printHelp();
                }               
            }
            else if (calculator instanceof Calculator) {
                System.out.println(calculator.toString());
                String input = StringHelper.removeWhitespace(scan.nextLine());
                            
                if (input.equals("exit")) {
                    break;  
                }
                else if (Pattern.matches(calculator.INPUT_PATTERN, input)) {
                    calculator.calculate(input);
                }
                else {
                    System.out.println("Bad command");
                }
            }
        } 
        scan.close();
    } 
}
 
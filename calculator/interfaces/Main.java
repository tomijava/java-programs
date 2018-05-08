package calculator.interfaces;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.regex.*;
import java.time.ZoneId;

public class Main {

    public static final String basicCalculator = "1";
    public static final String moduloCalculator = "2";
    public static final String binaryCalculator = "3";
    public static final String dateAndTimeCalculator = "4";
   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String calculatorModel = "0";
        Pattern pattern;
        Calculator calculator = null;
        CalculatorDateAndTime calculatorDateAndTime = null;

        System.out.println("Please chose calculator model");
        System.out.println("Enter 1 for basic calculator");
        System.out.println("Enter 2 for modulo calculator");
        System.out.println("Enter 3 for binary calculator");
        System.out.println("Enter 4 for Date and Time calculator");

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
                pattern = Pattern.compile("[\\+\\-\\/\\*]{1}[0-1]*");
                break;
            }
            else if (calculatorModel.equals(dateAndTimeCalculator)) {
                System.out.println("Choose your time zone");

                for (Zone id : Zone.values()) {
                    System.out.println(id.number + ": " + id);
                }
                int city = scan.nextInt();
                scan.nextLine();
                Zone d = Zone.PARIS;
                for (Zone id : Zone.values()) {
                    if (id.number == city) {
                        System.out.printf("You choosed %s zone %n", id.idZone);
                        d = id;
                        break;
                    }
                }
                calculatorDateAndTime = new CalculatorDateAndTime(d);
                pattern = Pattern.compile("^([\\+\\-])\\s*((\\d*)y)?\\s*((\\d*)m)?\\s*((\\d*)d)?\\s*((\\d*)h)?\\s*((\\d*)min)?\\s*((\\d*)s)?$");
                break;
            }
            else {
                System.out.println("Bad command");
            }
        }
        while (true) {
            if (calculatorDateAndTime != null) {
                System.out.println(calculatorDateAndTime.toString());
                String input = StringHelper.removeWhitespace(scan.nextLine());
                Matcher matcher = pattern.matcher(input);
                Pattern patternForShowSince = Pattern.compile("^showSecondsSince(\\d{1,4})\\s?([1-9]|1[0-2])?\\s?([1-9]|1[0-9]|2[0-9]|3[01])?$"); 
                Matcher matcherForShowSince = patternForShowSince.matcher(input);            
                if (input.equals("exit")) {
                    break;  
                }
                else if (matcher.matches()) {
                    calculatorDateAndTime.calculate(input);
                }
                else if (input.equals("changeCity")) {
                    for (Zone id : Zone.values()) {
                        System.out.println(id.number + " " + id);
                    }
                    System.out.println("Enter the city number");
                    while (true) {
                        int city = scan.nextInt();
                        scan.nextLine();
                        if (city >= 1 && city <= 8) {
                            for (Zone id : Zone.values()) {
                                if (id.number == city) {
                                    calculatorDateAndTime = new CalculatorDateAndTime(id);
                                    break;
                                }
                            }
                            break;       
                        }
                        else {
                            System.out.println("Bad command enter correct number");
                        }
                    }
                }
                else if (input.equals("whenSunday")) {
                    System.out.println(calculatorDateAndTime.whenSunday());

                }
                else if (matcherForShowSince.matches()) {
                                        
                    calculatorDateAndTime.showSecondsSince(input);
                }
                else if (input.equals("help")) {
                    calculatorDateAndTime.printHelp();
                }
                else {
                    System.out.println("Bad command");
                    calculatorDateAndTime.printHelp();
                }               
            }
            else {
                System.out.println(calculator.toString());
                String input = StringHelper.removeWhitespace(scan.nextLine());
                Matcher matcher = pattern.matcher(input);
                            
                if (input.equals("exit")) {
                    break;  
                }
                else if (matcher.matches()) {
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
 
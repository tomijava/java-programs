package calculator.interfaces;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String calculatorModel = "0";

        closeProgram: 
            while(true) {
                System.out.println("Please chose calculator model");
                System.out.println("Enter 1 for basic calculator");
                System.out.println("Enter 2 for modulo calculator");
                    
                calculatorModel = scan.nextLine();

                if (calculatorModel.equals("1")) {
                    Calculator calculatorBasic = new CalculatorBasic();
                    while(true) {
                        System.out.println(calculatorBasic.toString());
                        String input = StringHelper.removeWhitespace(scan.nextLine());
                        try {
                            if (input.equals("exit")) {
                                break closeProgram;  
                            }
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
                                default:
                                    System.out.println("Invalid command");
                            }
                        } catch (Exception exceptions) {
                            System.out.println("Invalid command");
                        }
                    }
                }
                else if (calculatorModel.equals("2")) {
                    System.out.println("Enter modulo number");
                    Calculator calculatorModulo = new CalculatorModulo(scan.nextInt());
                    scan.nextLine();
                    while(true) {
                        System.out.println(calculatorModulo.toString());
                        String input = StringHelper.removeWhitespace(scan.nextLine());
                        try {
                            if (input.equals("exit")) {
                                break closeProgram;  
                            }
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
                                default:
                                    System.out.println("Invalid command");
                            }
                        } catch (Exception exceptions) {
                            System.out.println("Invalid command");
                        }
                    }
                }
                else {
                    System.out.println("Invalid command");
            }
        }
    }
}
 
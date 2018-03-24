import java.util.*;
import java.lang.*;

public class Calculator {

    enum MathOperator {
        SUM, SUBSTRACTION, DIVIDE, MULTIPLCATION;

    }

    public static void removeWhiteSpace (StringBuilder string) {

        for (int i = 0; i<string.length(); i++) {


            if (Character.isWhitespace(string.charAt(i))) {
                string.deleteCharAt(i);
                i--;
            }
        }
    }

    public static double calculation (double result, double number, MathOperator operator) {
        
       
        switch(operator) {

            case SUM : result = result + number; break;
            case SUBSTRACTION: result =  result - number; break;
            case DIVIDE: result = result / number; break;
            case MULTIPLCATION: result = result * number; break;

        }
        return result;
    } 

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        double result = 0;

        while(true) {

            System.out.println(result);

            StringBuilder input = new StringBuilder(scan.nextLine());

            Calculator.removeWhiteSpace(input);

            StringBuilder stringNumber = new StringBuilder("");       
      
            try {

                if (input.toString().equals("exit")) {
                    break;
                }

                else {

                    for (int i = 1; i< input.length(); i++) {

                        if (!(input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) == '.')) {

                        break;

                        }

                        else {  
                            stringNumber.append(input.charAt(i));
                        }
                    }

                    switch (input.charAt(0)) {

                    case '+':
                        result = Calculator.calculation(result, Double.parseDouble(stringNumber.toString()), MathOperator.SUM);
                        break;
                    case '-':
                        result = Calculator.calculation(result, Double.parseDouble(stringNumber.toString()), MathOperator.SUBSTRACTION);
                        break;

                    case '/':
                        result = Calculator.calculation(result, Double.parseDouble(stringNumber.toString()), MathOperator.DIVIDE);
                        break;
                    case '*':
                        result = Calculator.calculation(result, Double.parseDouble(stringNumber.toString()), MathOperator.MULTIPLCATION);
                        break;
                    default : 
                        System.out.println("Złe polecenie");
                    }
                } 
            } catch (StringIndexOutOfBoundsException err) {
                        System.out.println("Zle polecenie");
            } catch (NumberFormatException err2) {
                        System.out.println("Zle Polecenie");                           
            }
        }
    }
}

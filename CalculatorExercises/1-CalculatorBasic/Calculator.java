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

    public static double operation (double score, double number, MathOperator operator) {
        
        double result = 0;
        switch(operator) {

            case SUM : result = score + number; break;
            case SUBSTRACTION: result =  score - number; break;
            case DIVIDE: result = score / number; break;
            case MULTIPLCATION: result = score * number; break;

        }
        return result;
    } 




    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Double number = new Double(30);
        
        double result1 = 0; 

        List<String> history = new ArrayList<String>();



        while(true) {

            boolean cont = true;

            StringBuilder string = new StringBuilder("");

            StringBuilder string2 = new StringBuilder("");

            System.out.println(result1);

            string.append(scan.nextLine());

            Calculator.removeWhiteSpace(string);

            if (string.toString().equals("exit")) {
                break;
            }

            else if (string.toString().equals("show")) {

            	for (String equation : history) {

            		System.out.println(equation);
            	}
            }

            else {

                for (int i = 1; i< string.length(); i++) {

                    if (!(string.charAt(i) >= '0' && string.charAt(i) <= '9' || string.charAt(i) == '.')) {

                    System.out.println("Zle polecenie");
                
                    cont = false;

                    break;

                    }

                    else {  
                        string2.append(string.charAt(i));
                    }
                }

                try {

                number = number.parseDouble(string2.toString());;

                } catch (NumberFormatException e) {

                    continue;
                }

                
                if(cont) {

                    switch (string.charAt(0)) {

                    case '+':
                        result1 = Calculator.operation(result1, number, MathOperator.SUM);
                        history.add((result1 - number) + " + " + number + " = " + result1);
                        break;

                    case '-':
                        result1 = Calculator.operation(result1, number, MathOperator.SUBSTRACTION);
                        history.add((result1 + number) + " - " + number + " = " + result1);
                        break;

                    case '/':
                        result1 = Calculator.operation(result1, number, MathOperator.DIVIDE);
                        history.add((result1 * number) + " / " + number + " = " + result1);
                        break;

                    case '*':
                        result1 = Calculator.operation(result1, number, MathOperator.MULTIPLCATION);
                        history.add((result1 / number) + " * " + number + " = " + result1);
                        break;

                    default:
                        System.out.println("Zle polecenie");
                        break;
                    }                   
                }
            }
        }
    }
}

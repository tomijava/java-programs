import java.util.*;
import java.lang.*;

public class Calculator {
   
    private static double result = 0;

    public static double getResult() {
        return result;
    }

    public static void calculation (StringBuilder input) {
        
        StringBuilder numberek = new StringBuilder("");
        boolean calculate = true;

        try {
            if (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '/' || input.charAt(0) == '*') {
                for (int i = 1; i < input.length(); i++) {
                    if (input.charAt(i) >= '0' && input.charAt(i) <= '9' || input.charAt(i) == '.') {
                        numberek.append(input.charAt(i));
                    }
                    else {
                        calculate = false;
                        System.out.println("Zle polecenie");
                        break;
                    }
                }
            }           
            if (calculate) {
                double number = Double.valueOf(numberek.toString());

                switch (input.charAt(0)) {
                case '+':
                    result += number; 
                    break;
                case '-':
                    result -= number;
                    break;
                case '/':
                    result /= number;
                    break;
                case '*':
                    result *= number;
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
 
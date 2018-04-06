import java.util.*;
import java.lang.*;

public class Calculator {
   
    private double result;

    public double getResult() {
        return result;
    }

    public Calculator () {
        this.result = 0;
    }

    public void calculate (String input) {
        try {
                switch (input.charAt(0)) {
                case '+':
                    result += Double.valueOf(input.substring(1)); 
                    break;
                case '-':
                    result -= Double.valueOf(input.substring(1));
                    break;
                case '/':
                    result /= Double.valueOf(input.substring(1));
                    break;
                case '*':
                    result *= Double.valueOf(input.substring(1));
                    break;
                default : 
                    System.out.println("Zle polecenie");
                    break;
                }       
            
            } catch (StringIndexOutOfBoundsException err) {
                System.out.println("Zle polecenie");
            } catch (NumberFormatException err2) {
                System.out.println("Zle Polecenie");                           
        }
    }
}
 
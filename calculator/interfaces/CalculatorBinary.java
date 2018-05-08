package calculator.interfaces;
import java.lang.Math;
public class CalculatorBinary implements Calculator {
    private int result;

    public CalculatorBinary() {
        this.result = 0;
    }

    public String toString() {
        if (result == 0) {
            return "0";
        }
        else {
            return changeToBinary();
        }
    }  
    public void calculate(String number) {
        StringBuilder input = new StringBuilder(number);

        if (input.charAt(0) == '+') {
            add(input.substring(1));
        }
        else if (input.charAt(0) == '-') {
            subtract(input.substring(1));
        }
        else if (input.charAt(0) == '/') {
            divide(input.substring(1));
        }
        else if (input.charAt(0) == '*') {
            multiply(input.substring(1));
        }
    }
    private String changeToBinary() {
        StringBuilder number = new StringBuilder();
        int resultToConvert = this.result;
        if (resultToConvert > 0) {
            while (resultToConvert > 0) {
                if (resultToConvert % 2 == 1) {
                    number.append(1);
                }
                else {
                    number.append(0);
                }
                resultToConvert /= 2;
            }
            return number.reverse().toString();
        }
        else if (Math.round(resultToConvert) < 0) {
            while (Math.round(resultToConvert) < 0) {
                if (resultToConvert % 2 == -1) {
                    number.append(1);
                }
                else {
                    number.append(0);
                }

                resultToConvert /= 2;
            }
            number.append("-");
            return number.reverse().toString();
        }
        else {
            return "0";
        }
    } 
    private void add (String input) {
        StringBuilder number = new StringBuilder(input);
        for (int index = 0; index < number.length(); index++) {
            if(number.charAt(index) == '1') {
                this.result += Math.pow(2, ((number.length() - 1) - index));
            }
        }
    }
    private void subtract (String input) {
        StringBuilder number = new StringBuilder(input);
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) == '1') {
                this.result -= Math.pow(2, ((number.length() - 1) - index));
            }
        }
    }
    private void divide (String input) {
        StringBuilder number = new StringBuilder(input);
        int divider = 0;
        for (int index = 0; index < number.length(); index++) {
            if (number.charAt(index) == '1') {
                divider += Math.pow(2, ((number.length() - 1) - index));
            }
        }
        this.result /= divider;
    }
    private void multiply (String input) {
        StringBuilder number = new StringBuilder(input);
        int multipler = 0;
        for (int index = 0; index < number.length()-1; index++) {
            if (number.charAt(index) == '1') {
                multipler += Math.pow(2, ((number.length() - 1) - index));
            }
        }
        this.result *= multipler;
    }
}

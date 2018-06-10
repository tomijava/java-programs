package calculator;

public class CalculatorBinary implements Calculator {

    private int result;
    public static final String INPUT_PATTERN = "[\\+\\-\\/\\*]{1}[0-1]*";
    // example for pattern +101, -101001, *10010101, /001
    
    public CalculatorBinary() {
        this.result = 0;
    }

    public String toString() {
        return getResultAsBinaryString();      
    }  

    public void calculate(String number) {
        StringBuilder input = new StringBuilder(number);
        
        switch (input.charAt(0)) {
            case '+':
                add(input.substring(1));
                break;
            case '-':
                subtract(input.substring(1));
                break;
            case '/':
                divide(input.substring(1));
                break;
            case '*':
                multiply(input.substring(1));
                break;
        }
    }

    private String getResultAsBinaryString() {
        StringBuilder resultAsBinary = new StringBuilder();
        int resultToConvert = Math.abs(this.result);
        if (resultToConvert == 0) {
            return "0";
        }
        while (resultToConvert > 0) {
            if (resultToConvert % 2 == 1) {
                resultAsBinary.append(1);
            }
            else {
                resultAsBinary.append(0);
            }
            resultToConvert /= 2;
        }
        if (this.result < 0) {
            resultAsBinary.append("-");
        }
        return resultAsBinary.reverse().toString();
    }

    public static int getBinaryStringAsInt(String binary) {
        StringBuilder number = new StringBuilder(binary);
        int binaryNumberAsDecimal = 0;
        for (int index = 0; index < number.length(); index++) {
            if(number.charAt(index) == '1') {
                binaryNumberAsDecimal += Math.pow(2, ((number.length() - 1) - index));
            }
        }
        return binaryNumberAsDecimal;
    } 

    private void add (String input) {
        this.result += getBinaryStringAsInt(input);
    }
    private void subtract (String input) {
        this.result -= getBinaryStringAsInt(input);
    }
    private void divide (String input) {
        this.result /= getBinaryStringAsInt(input);
    }
    private void multiply (String input) {
        this.result *= getBinaryStringAsInt(input);
    }
}

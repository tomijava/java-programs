package calculator;

public class CalculatorModulo implements Calculator {

    private double result;
    private double modulo;
    public static final String INPUT_PATTERN = "[\\+\\-\\*\\/]{1}[0-9]+"; 

    public CalculatorModulo (double modulo) {
        this.result = 0;
        this.modulo = modulo;
    }

    public String toString() {

        if (this.result == (int)this.result) {
            return Integer.toString((int)this.result);
        }
        else {
            return Double.toString(this.result);
        }
    }
    public void calculate (String number) {

        StringBuilder input = new StringBuilder(number);  

        switch (input.charAt(0)) {
            case '+' :
                add(Double.parseDouble(input.substring(1)));
                break;
            case '-' :
                subtract(Double.parseDouble(input.substring(1)));
                break;
            case '/':
                divide(Double.parseDouble(input.substring(1)));
                break;
            case '*':
                multiply(Double.parseDouble(input.substring(1)));
                break;
        }
    }
    
    private  void add (double number) {
        this.result = (this.result + number) % modulo;
    }
    private void subtract (double number) {
        this.result = (this.result - number) % modulo;
    }
    private void divide (double number) {
        this.result = (this.result / number) % modulo;
    }
    private void multiply (double number) {
        this.result = (this.result * number) % modulo;
    }
}
    
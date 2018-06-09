package calculator;

public class CalculatorBasic implements Calculator {
   
    private double result;
    String INPUT_PATTERN = "[\\+\\-\\*\\/]{1}[0-9]+";
    //Example patterns +1, -23, *403, /5  

    public CalculatorBasic() {
        this.result = 0;
    }    

    public double getResult() {
        return this.result;
    }

    public String toString() {
        if (this.result == (int)this.result) {
            return Integer.toString((int)this.result);
        }
        else {
            return Double.toString(this.result);
        }
    } 
    public void calculate(String number) {
        StringBuilder input = new StringBuilder(number);  

        switch (input.charAt(0)) {
            case '+':
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
    private void add(double number) {
        this.result += number;
    }
    private void subtract(double number) {
        this.result -= number;
    }
    private void divide(double number) {
        this.result /= number;
    }
    private void multiply(double number) {
        this.result *= number;
    }
}
 
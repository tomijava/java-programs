package calculator.basic;

public class Calculator {
   
    private double result;

    public Calculator () {
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

    public void calculate (String input) {
        try {
            switch (input.charAt(0)) {
                case '+':
                    add(Double.valueOf(input.substring(1))); 
                    break;
                case '-':
                    subtract(Double.valueOf(input.substring(1)));
                    break;
                case '/':
                    divide(Double.valueOf(input.substring(1)));
                    break;
                case '*':
                    multiply(Double.valueOf(input.substring(1)));
                    break;
                default : 
                    System.out.println("Zle polecenie");
                    break;
            }              
        } 
        catch (Exception exception) {
            System.out.println("Zle polecenie");
        } 
    }
}
 
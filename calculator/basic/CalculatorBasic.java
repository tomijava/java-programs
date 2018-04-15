package calculator.basic;

public class CalculatorBasic implements Calculator {
   
    private double result;

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

    public void add(double number) {
        this.result += number;
    }
    public void subtract(double number) {
        this.result -= number;
    }
    public void divide(double number) {
        this.result /= number;
    }
    public void multiply(double number) {
        this.result *= number;
    }
}
 
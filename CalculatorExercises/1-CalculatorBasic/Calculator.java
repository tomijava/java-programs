public class Calculator {
   
    private double result;

    public Calculator () {
        this.result = 0;
    }    

    public double getResult() {
        return result;
    }

    public String toString(double result) {

        if (result == (int)result) {
            return Integer.toString((int)result);
        }
        else {
            return Double.toString(result);
        }
    } 

    private void add(double number) {
        this.result += number;
    }
    private void substract(double number) {
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
                    substract(Double.valueOf(input.substring(1)));
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
        catch (StringIndexOutOfBoundsException | NumberFormatException error) {
            System.out.println("Zle polecenie");
        } 
    }
}
 
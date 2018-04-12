package calculator.interfaces;

public class CalculatorModulo implements Calculator {

	private double result;
	private double modulo;

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
   	
   	public void add (double number) {
   		this.result = (this.result + number) % this.modulo;
   	}
   	public void subtract (double number) {
   		this.result = (this.result - number) % this.modulo;
   	}
   	public void divide (double number) {
   		this.result = (this.result / number) % this.modulo;
   	}
   	public void multiply (double number) {
   		this.result = (this.result * number) % this.modulo;
   	}
}
	
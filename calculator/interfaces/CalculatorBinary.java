package calculator.interfaces;
import java.lang.Math;
public class CalculatorBinary implements Calculator {
	private String resultInBinary;
	private int result;

	public CalculatorBinary() {
		this.resultInBinary = "0";
		this.result = 0;
	}

	public String toString() {
		return this.resultInBinary;
	}	
	public void add(double number) {
		int x = (int)number;
		StringBuilder stringNumber = new StringBuilder((x));
		for (int index = 0; index < stringNumber.length(); index++) {
			if(stringNumber.charAt(index) == '1') {
				this.result += Math.pow(2, ((stringNumber.length() - 1) - index));
			}
		}
		StringBuilder changeToBinary = new StringBuilder();
		int result2 = this.result;
		while (result2 > 0) {
			if(result2 % 2 == 1) {
				changeToBinary.append(1);
			}
			else {
				changeToBinary.append(0);
			}
			result2 /= 2;
		}
		this.resultInBinary = changeToBinary.reverse().toString();
	}
	public void subtract(double number) {}
	public void multiply(double number) {}
	public void divide(double number) {}
}

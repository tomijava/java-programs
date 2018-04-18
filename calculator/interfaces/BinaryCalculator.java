import java.util.Scanner;
import java.lang.Math;
public class BinaryCalculator {
	
	private static String resultBinary = "0";
	private static int result = 0;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(BinaryCalculator.resultBinary);
			StringBuilder input = new StringBuilder(scan.nextLine());
			if (input.toString().equals("exit")){
				break;
			}
			for (int x = 0; x < input.length(); x++) {
				if (input.charAt(x) == '1') {
					if (x == input.length()- 1) {
						BinaryCalculator.result += 1;
					}
					else {
						BinaryCalculator.result += Math.pow(2, ((input.length() - 1)- x));	
					}
				}	
			}
			int resulten = BinaryCalculator.result;
			StringBuilder binaryResult = new StringBuilder();
			while (resulten > 0) {
				if (resulten % 2 == 1) {
					binaryResult.append(1);
				}
				else {
					binaryResult.append(0);
				}
				resulten /= 2;
			}
			resultBinary = binaryResult.reverse().toString();
		}
	}
}

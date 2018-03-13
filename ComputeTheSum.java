import java.util.Scanner;


public class ComputeTheSum {

	//Write a Java program and compute the sum of the digits of an integer.
	
	public static int sumDigit(int number) {
		int sum = 0;
		while(number != 0) {
			int digit = number % 10;
			sum += digit;
			number /= 10;
		}
	return sum;
	}

	public static void main(String[] args) {

		Scanner scan =  new Scanner(System.in);
		int exit = 1;
		while(exit == 1) {
		System.out.println("Enter the number");
		int number = scan.nextInt();
		System.out.println("Sum digits = " + sumDigit(number));
		System.out.println("Enter 1 to continue or enter 0 to exit");
		exit = scan.nextInt();
		}
	scan.close();
	}
}

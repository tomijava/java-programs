import java.util.Scanner;

public class CompareTwoNumbers {
	public static void main(String[] args) {
		int continueOrExit = 0;
		Scanner scan = new Scanner(System.in);

		while(continueOrExit == 0) {
			System.out.println("Enter first number");
			int firstNumber = scan.nextInt();
			System.out.println("Enter second number");
			int secondNumber = scan.nextInt();
			scan.nextLine();

			if(firstNumber > secondNumber) {
				System.out.println(firstNumber + " is greater than " + secondNumber);
			}
			else if(firstNumber < secondNumber) {
				System.out.println(secondNumber + " is greater than " + firstNumber);
			}
			else if(firstNumber == secondNumber) {
				System.out.println(firstNumber + " is equal " + secondNumber);
			}

			System.out.println("Enter 0 to continue or enter 1 to exit");
			continueOrExit = scan.nextInt();
		}
		scan.close();
	}
}

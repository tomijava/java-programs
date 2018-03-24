import java.util.Scanner;
import java.util.Random;

public class ArraySecondExercise {
    public static void main(String[] args) {
         //Write a Java program to test if an array contains a specific value
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int[] randomIntArray = new int[100];

        for (int numberIndex = 0; numberIndex < randomIntArray.length; numberIndex++) {
            randomIntArray[numberIndex] = random.nextInt(101);
        }

        System.out.println("Enter number to search");

        while (true) {
            
            int numberToSearch = scan.nextInt();

            int numberOfOccurences = 0;

            for (int numberIndex : randomIntArray) {
            
                if (numberIndex ==  numberToSearch) {
                    numberOfOccurences ++;
                }        

            }

            if (numberOfOccurences == 1) {
                System.out.println(numberToSearch + " appeared in array " + numberOfOccurences + " time");

            }
            else if (numberOfOccurences > 1) {
            System.out.println(numberToSearch + " appeared in array " + numberOfOccurences + " times"); 
            }
            else {
                System.out.println("No number in array");
            }

            System.out.println("Try again, enter number");
        }  
    }

}

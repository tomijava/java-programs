import java.util.Scanner;
import java.util.Random;

public class ArraySecondExercise {
    public static void main(String[] args) {
         //Write a Java program to test if an array contains a specific value
        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        int[] array = new int[100];

        for (int numberOfIndex = 0; numberOfIndex < array.length; numberOfIndex++) {
            array[numberOfIndex] = random.nextInt(100);
        }

        System.out.println("Enter number to search");

        while (true) {
            
            int numberToSearch = scan.nextInt();

            int numberOfExecptions = 0;

            for (int numberOfIndex : array) {
            
                if (numberOfIndex ==  numberToSearch) {
                    numberOfExecptions ++;
                }        

            }

            if (numberOfExecptions == 1) {
                System.out.println(numberToSearch + " appeared in array " + numberOfExecptions + " time");

            }
            else if (numberOfExecptions > 1) {
            System.out.println(numberToSearch + " appeared in array " + numberOfExecptions + " times"); 
            }
            else {
                System.out.println("No number in array");
            }

            System.out.println("Try again, enter number");
        }  
    }

}

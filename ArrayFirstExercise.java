import java.util.Scanner;
import java.util.Random;

public class ArrayFirstExercise {

    public enum ContinueOrExit {
        CONTINUE(1), EXIT(0);

        private int value;

        ContinueOrExit(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static void main(String[] args) {
        // sum values of an array

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        
        while(true) {

            int sumElementsInArray = 0;
            int sumElementsInArrayV2 = 0;

            System.out.println("Enter the size of the array");
            int sizeArray = scan.nextInt();
            scan.nextLine();
            
            int[] array = new int[sizeArray];
           
            /* assigning a value to elements of the array and
            and sums all elements in the array */
            for (int indexOfNumber = 0; indexOfNumber < array.length; indexOfNumber++) {
                array[indexOfNumber] = random.nextInt(100);
                sumElementsInArray += array[indexOfNumber];

            }
            // another way
            for(int indexOfNumber : array) {
                indexOfNumber = random.nextInt(100) - 50;
                sumElementsInArrayV2 += indexOfNumber;
                System.out.print(indexOfNumber + " ");
            }

            System.out.println(sumElementsInArrayV2);
            System.out.println();
            System.out.println("----------------");


            //print value all elements of array
            for (int indexOfNumber = 0; indexOfNumber < array.length; indexOfNumber++) {
                System.out.print(array[indexOfNumber] + " ");
            }
            System.out.println();
            System.out.println("----------------");

            //another way 
            for(int indexOfNumber : array) {
                System.out.print(indexOfNumber + " ");
            }

            System.out.println();

            System.out.println();
            System.out.println("Thier sum is equal = " + sumElementsInArray);
        
            System.out.println("Enter 1 to continue or 0 to exit");
            int whatToDO = scan.nextInt();

            if (whatToDO == ContinueOrExit.CONTINUE.value) {
                continue;
            }
            else if (whatToDO == ContinueOrExit.EXIT.value) {
                break;
            } 

        }
        scan.close();
    }
}

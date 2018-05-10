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
        
        while (true) {

            int sumOfElementsInArray = 0;

            System.out.println("Enter the size of the array");
            int sizeArray = scan.nextInt();
            
            int[] intArray = new int[sizeArray];

            for (int indexOfArrayInt : intArray) {
                indexOfArrayInt = random.nextInt(101);
                sumOfElementsInArray += indexOfArrayInt;
                System.out.print(indexOfArrayInt + " + ");
            }

            System.out.println(" = " + sumOfElementsInArray);
        
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

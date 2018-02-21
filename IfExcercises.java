import java.util.Scanner;

public class IfExcercises {
	public static void main(String[] args) {
		/*Napisz program, który sprawdza dla trzech boków trójkąta a ,
		b i c wprowadzonych z klawiatury, czy tworzą one trójkąt pro-
		stokątny (zakładamy, że a > 0 , b > 0 , c > 0 ).
		*/

		Scanner scanner = new Scanner(System.in);

		int a, b, c;
		System.out.println("Enter length sides triangle:" + "\n" + "Side a: ");
		a = scanner.nextInt();
		
		System.out.println("Side b:");
		b = scanner.nextInt();
		
		System.out.println("Side c");
		c= scanner.nextInt();
		scanner.nextLine();

		if((a*a) + (b*b) == c*c)
		{
			System.out.println("Triangle is rectangular");
		}
		else
		{
			System.out.println("Triangle isn't rectangular");
		}
		
		/*Napisz program, który oblicza pierwiastki równania kwadra-
		towego ax 2 +bx+c = 0 z wykorzystaniem instrukcji warunkowej
		if , gdzie zmienne a , b i c to liczby rzeczywiste wprowadzane
		z klawiatury. Dla zmiennych a , b , c , x1 oraz x2 należy przyjąć
		format wyświetlania ich na ekranie z dokładnością do dwóch
		miejsc po przecinku.
		*/
		
		
		double x1, x2;
		System.out.println("ax^2 + bx + c =0; Enter a, b, c for calculate x");
		System.out.println("Enter a");
		double a2 = scanner.nextDouble();
		System.out.println("Enter b");
		double b2 = scanner.nextDouble();
		System.out.println("Enter c");
		double c2 = scanner.nextDouble();
		scanner.nextLine();
		double delta = (b2*b2) - (4*a2*c2);

		if(delta == 0)
		{
			x1 = (-b2/(2*a2));
			System.out.print(delta + " = 0 ");
			System.out.printf("x1 = %.2f%n", x1);
		}
		else if(delta>0)
		{
			x1 = (-b2 - Math.sqrt(delta))/(2*a2);
			x2 = (-b2 + Math.sqrt(delta))/(2*a2);
			System.out.print(delta + " > 0 ");
			System.out.printf("x1 = %.2f", x1);
			System.out.printf(" x2 = %.2f%n", x2);
		}
		else if(delta < 0)
		{
			System.out.println(delta + " < 0, No elements");
		}
	}
}

import java.util.Scanner;

public class StringBuilderExcercise {

	public static void main(String[] args) {
	/*
		Pobierz od użytkownika liczbę, która określać będzie ile wyrazów użytkownik chce wprowadzić. 
		Następnie wczytaj od niego listę ciągów znaków na podstawie, których wygenerujesz wynik.

		Wynikiem jest wyraz składający się z ostatnich liter każdego z wprowadzonych słów. 
		Wykorzystaj klasy String i StringBuilder.
	*/	
		StringBuilder builder = new StringBuilder();
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Enter the number of words: ");
		int wordsNumber = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Number of words: " + wordsNumber);
		
		for(int i = 1; i<=wordsNumber; i++)
		{
			System.out.println("Enter " + (i) + " word");
			String word = scanner.nextLine();
			builder.append(word.charAt(word.length()-1));
		}
		System.out.println(builder.toString());
		scanner.close();
	}

}

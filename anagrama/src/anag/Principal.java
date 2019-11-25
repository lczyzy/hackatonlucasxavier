package anag;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("### ANAGRAMAS ###");

		System.out.printf("Informe uma palavra: ");
		String palavra = sc.nextLine();

		// tirar espaco e colocar maiscula
		palavra = palavra.replace(" ", "").toUpperCase();

		// ver se string possui numeros ou caracteres especiais
		boolean apenasLetras = palavra.chars().allMatch(Character::isLetter);

		// condicao para parar aplicacaoc caso encontre carateres invalidos
		if (apenasLetras != true) {
			System.out.println("Caracteres inválidos encontrados");
			System.exit(0);
		} else {

			List<String> listaAnagramas = new ArrayList<>();

			// leitura arquivo
			try (FileReader reader = new FileReader("C:/Users/lcz-x/Desktop/palavras.82eebac6.txt");
					BufferedReader br = new BufferedReader(reader)) {

				

				String line;
				while ((line = br.readLine()) != null) {

					boolean ordenado = anag(line, palavra);

					if (ordenado == true) {
						listaAnagramas.add(line);
					}

				}

			} catch (IOException e) {
				System.err.format("IOException: %s%n", e);
			}
			sc.close();

			// exibir lista anagramas
			if (listaAnagramas.isEmpty()) {
				System.out.println("\n\nEstá palavra não possui anagramas");
			} else {
				System.out.print("\n\nPalavra: " + palavra);

				System.out.println(" - Anagramas: \n");
				for (String item : listaAnagramas) {
					System.out.println(item);
				}
			}

		}

	}

	// metodo para checar se é anagrama ou não de acordo com a palavra informada
	private static boolean anag(String x, String y) {
		char[] a = x.toCharArray();
		Arrays.sort(a);

		char[] b = y.toCharArray();
		Arrays.sort(b);

		boolean status = Arrays.equals(a, b);

		return status;
	}

}

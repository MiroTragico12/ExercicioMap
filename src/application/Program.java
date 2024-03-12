package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;



public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Map<String, Integer> map = new TreeMap<>();

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String nome = fields[0];
				int votos = Integer.parseInt(fields[1]);
				line = br.readLine();

				map.put(nome, votos);

			}
			for (String nome : map.keySet()) {
				System.out.println(nome + ": " + map.get(nome));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			sc.close();
		}
	}
}
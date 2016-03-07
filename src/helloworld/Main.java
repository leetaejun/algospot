package helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		List<String> helloList = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		
		for (int i = 0; i < count; i++) {
			helloList.add(scanner.next());
		}
		
		for (int i = 0; i < helloList.size(); i++) {
			System.out.println("Hello, " + helloList.get(i) + "!");
		}
	}
}

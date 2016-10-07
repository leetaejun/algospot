package net.acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2605

public class P2605 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		int count = scan.nextInt();
		
		List<Integer> pickNumberList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			pickNumberList.add(scan.nextInt());
		}
		
		List<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < pickNumberList.size(); i++) {
			linkedList.add(pickNumberList.get(i), i+1);
		}
		
		for (int i = linkedList.size()-1; i >= 0; i--) {
			System.out.print(linkedList.get(i) + " ");
		}
	}
}

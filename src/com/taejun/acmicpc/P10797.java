package com.taejun.acmicpc;

import java.util.Scanner;

public class P10797 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int limitedCarNumber = scanner.nextInt();
		int resultCount = 0;
		for (int i = 0; i < 5; i ++) {
			int inputNumber = scanner.nextInt();
			
			if (limitedCarNumber == inputNumber) {
				resultCount++;
			}
		}
		
		System.out.println(resultCount);
	}
}

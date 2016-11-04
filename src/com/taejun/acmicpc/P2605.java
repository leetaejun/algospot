package com.taejun.acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2605

public class P2605 {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);

		int count = scan.nextInt();

		// 입력
		List<Integer> pickNumberList = new ArrayList<>();
		for (int i = 0; i < count; i++) {
			pickNumberList.add(scan.nextInt());
		}

		// LinkedList를 통해 뽑은 자리 인덱스에 배치
		List<Integer> linkedList = new LinkedList<>();
		for (int i = 0; i < pickNumberList.size(); i++) {
			linkedList.add(pickNumberList.get(i), i + 1);
		}

		// 출력
		for (int i = linkedList.size() - 1; i >= 0; i--) {
			System.out.print(linkedList.get(i) + " ");
		}
	}
}

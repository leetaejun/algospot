package com.taejun.acmicpc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2309

public class P2309 {
	public static void main(String args[]) {
		List<Integer> peopleList = new ArrayList<Integer>();
		
		// 입력
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			peopleList.add(scan.nextInt());
		}
		
		// 오름차순으로 정렬
		Collections.sort(peopleList);
		
		// 결과적으로 제외될 두 명의 인덱스를 선언
		int exceptionIndex1 = 0;
		int exceptionIndex2 = 0;
		
		int sum = 0;
		for (int i = 0; i < peopleList.size(); i++) {
			if (sum == 100) {
				break;
			}
			
			for (int j = 0; j < peopleList.size(); j++) {
				if (i == j) {
					continue;
				}
					
				sum = 0;
				for (int k = 0; k < peopleList.size(); k++) {
					if (k == i || k == j) {
						continue;
					}
					
					sum += peopleList.get(k);
					
					if (sum == 100) {
						exceptionIndex1 = i;
						exceptionIndex2 = j;
					}
				}
			}
		}
		
		// 출력
		for (int i = 0; i < peopleList.size(); i++) {
			if (i == exceptionIndex1 || i == exceptionIndex2) {
				continue;
			}
			
			System.out.println(peopleList.get(i));
		}
	}
}

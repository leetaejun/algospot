package net.acmicpc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

// https://www.acmicpc.net/problem/2606

public class P2606 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		int computerCount = scanner.nextInt();
		int connectedCount = scanner.nextInt();
		
		// 양방향 그래프 생성
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < connectedCount; i++) {
			int front = scanner.nextInt();
			int end = scanner.nextInt();
			
			Set<Integer> set = map.get(front);
			if (set == null) {
				set = new HashSet<>();
				map.put(front, set);
			}
			set.add(end);
			
			Set<Integer> sett = map.get(end);
			if (sett == null) {
				sett = new HashSet<>();
				map.put(end, sett);
			}
			sett.add(front);
		}
		
		// 탐색
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		Set<Integer> checkSet = new HashSet<>();
		int count = 0;
		checkSet.add(1);
        while (!queue.isEmpty()) {
        	Integer value = queue.poll();
        	Set<Integer> s = map.get(value);
        	if (s == null) continue;
        	for (Integer integer : s) {
        		if (!checkSet.contains(integer)) {
        			checkSet.add(integer);
        			queue.add(integer);
        			count++;
        		}
        	}
        }
        
        // 출력
        System.out.println(count);
	}
}

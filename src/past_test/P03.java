package past_test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * 0~100의 랜덤한 숫자가 있는 배열이 있을 때, O(N)의 시간내로 정렬된 리스트를 만들기 위한 알고리즘 문제풀이
 * 
 * @author leetaejun
 *
 */
public class P03 {
	public static void main(String args[]) {
		Scanner numberScanner = new Scanner(System.in);
		
		List<Integer> numberList = new LinkedList<>();
		int[] numberCountArray = new int[100+1];
		
		int[] testArray = {19, 21, 10, 1, 100, 99, 54, 56, 88, 12, 11, 13, 13, 0};
		
		for (int i = 0; i < testArray.length; i++) {
			numberCountArray[testArray[i]] += 1;
		}
		
		for (int j = 0; j < numberCountArray.length; j++) {
			for (int k = numberCountArray[j]-1; k >= 0; k--) {
				numberList.add(j);
			}
		}
		
		System.out.println(numberList.stream().map(String::valueOf).collect(Collectors.joining(", ")));
	}
	
	/*
	public static void sortListWithInputNumber(List<Integer> numberListToSort, Integer inputNumber) {
		int getLastIndexByList = numberListToSort.lastIndexOf(inputNumber.intValue());
		if (getLastIndexByList == -1) {
			int index = getIndexAtList(numberListToSort, inputNumber);
			
			if (index >= numberListToSort.size()) {
				numberListToSort.add(inputNumber);
			} else {
				numberListToSort.add(index, inputNumber);
			}
		} else {
			numberListToSort.add(getLastIndexByList, inputNumber);
		}
	}
	
	public static int getIndexAtList(List<Integer> numberList, Integer inputNumber) {
		if (numberList.size() == 0) {
			return 0;
		} else if (numberList.size() == 1) {
			if (inputNumber > numberList.get(0)) {
				return 1;
			} else {
				return 0;
			}
		} else {
			int minNumber = numberList.get(0);
			int maxNumber = numberList.get(numberList.size()-1);
			
			if (inputNumber <= minNumber) {
				return 0;
			} else if (inputNumber >= maxNumber) {
				return numberList.size();
			}
			
			int minIndex = 0;
			int maxIndex = numberList.size() - 1;
			int midIndex = -1;
			while (minIndex <= maxIndex) {
				midIndex = (minIndex + maxIndex) / 2;
				if (inputNumber > numberList.get(midIndex)) {
					minIndex = midIndex + 1;
				} else if (inputNumber < numberList.get(midIndex)) {
					maxIndex = midIndex - 1;
				}
				else {
					return midIndex;
				} 
			}
			
			return midIndex;
		}
	}
	*/
}

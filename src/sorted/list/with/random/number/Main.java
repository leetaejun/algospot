package sorted.list.with.random.number;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner numberScanner = new Scanner(System.in);
		
		List<Integer> numberList = new LinkedList<>();
		while (true) {
			System.out.print("리스트에 넣을 숫자를 입력해주세요.");
			Integer inputNumber = numberScanner.nextInt();
			
			if (inputNumber >= 0) {
				sortListWithInputNumber(numberList, inputNumber);	
			} else {
				System.out.println("0이상의 큰 숫자를 입력해주세요.");
			}
			
			
			for (int index = 0; index < numberList.size(); index++) {
				System.out.println("index : " + index + ", nubmer : " + numberList.get(index));
			}
		}
	}
	
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
}

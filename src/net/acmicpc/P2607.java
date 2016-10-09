package net.acmicpc;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

// https://www.acmicpc.net/problem/2607

public class P2607 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int iteratorCount = scanner.nextInt();
		scanner.nextLine();
		String standardWord = scanner.nextLine();

		int similarWordCount = 0;
		for (int i = 0; i < iteratorCount - 1; i++) {
			String seemLikeWord = scanner.nextLine();
			if (isSimilar(standardWord, seemLikeWord)) {
				similarWordCount++;
			}
		}
		System.out.println(similarWordCount);
	}

	private static boolean isSimilar(String standardWord, String compareWord) {
		if (standardWord.equals(compareWord)) {
			return true;
		}

		Map<Character, Integer> standardWordMap = getCharacterCountMap(standardWord);
		Map<Character, Integer> compareWordMap = getCharacterCountMap(compareWord);

		int diffCount = 0;
		for (Entry<Character, Integer> entry : standardWordMap.entrySet()) {
			char characterKey = entry.getKey();
			int countValue = entry.getValue();
			if (compareWordMap.containsKey(characterKey)) {
				diffCount += Math.abs(countValue - compareWordMap.get(characterKey));
				compareWordMap.remove(characterKey);
			} else {
				diffCount += countValue;
			}
		}

		for (Character key : compareWordMap.keySet()) {
			diffCount += compareWordMap.get(key);
		}

		if (standardWord.length() == compareWord.length() && diffCount <= 2) {
			return true;
		} else if (diffCount <= 1) {
			return true;
		} else {
			return false;
		}
	}

	private static Map<Character, Integer> getCharacterCountMap(String word) {
		Map<Character, Integer> characterCountMap = new HashMap<>();

		char[] wordCharArray = word.toCharArray();

		for (int i = 0; i < wordCharArray.length; i++) {
			if (characterCountMap.containsKey(wordCharArray[i])) {
				Integer count = characterCountMap.get(wordCharArray[i]);
				characterCountMap.put(wordCharArray[i], count + new Integer(1));
			} else {
				characterCountMap.put(wordCharArray[i], new Integer(1));
			}
		}

		return characterCountMap;
	}
}

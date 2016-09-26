package anagram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * ANAGRAM
 */

// 예제 입력
// 3
// weird wired
// apple angle
// apple elppa
//
// 예제 출력
// Yes
// No.
// Yes

public class Main {
	public static void main(String args[]) {
		List<String> helloList = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		int count = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < count; i++) {
			String s = scanner.nextLine();
			helloList.add(s);
		}
		
		for (int i = 0; i < helloList.size(); i++) {
			String[] splitSentence = helloList.get(i).split(" ");
			System.out.println(checkAnagram(splitSentence[0], splitSentence[1]));
		}
	}

	private static String checkAnagram(String sentence1, String sentence2) {
		// null 처리
		if (sentence1 == null || sentence2 == null || sentence1.length() != sentence2.length()) {
			return "No.";
		}

		// 각 문장의 Character를 담아둘 맵 생성(TreeMap을 통해 키 값으로 정렬)
		Map<Character, Integer> sentence1CharMap = new TreeMap<>();
		Map<Character, Integer> sentence2CharMap = new TreeMap<>();

		// 문자열을 문자 배열로 변경
		char[] sentence1CharArray = sentence1.toCharArray();
		char[] sentence2CharArray = sentence2.toCharArray();

		// 문자에 해당하는 카운트를 맵에 저장
		for (int i = 0; i < sentence1CharArray.length; i++) {
			if (sentence1CharMap.containsKey(sentence1CharArray[i])) {
				sentence1CharMap.put(sentence1CharArray[i],
						new Integer(sentence1CharMap.get(sentence1CharArray[i]).intValue() + 1));
			} else {
				sentence1CharMap.put(sentence1CharArray[i], new Integer(1));
			}
		}
		for (int i = 0; i < sentence2CharArray.length; i++) {
			if (sentence2CharMap.containsKey(sentence2CharArray[i])) {
				sentence2CharMap.put(sentence2CharArray[i],
						new Integer(sentence2CharMap.get(sentence2CharArray[i]).intValue() + 1));
			} else {
				sentence2CharMap.put(sentence2CharArray[i], new Integer(1));
			}
		}

		// 맵을 비교
		for (int i = 0; i < sentence1CharMap.size(); i++) {
			if (!(sentence1CharMap.keySet().equals(sentence2CharMap.keySet()))) {
				return "No.";
			}

			if (sentence1CharMap.get(sentence1CharArray[i]).intValue() != sentence2CharMap.get(sentence1CharArray[i])
					.intValue()) {
				return "No.";
			}
		}

		return "Yes";
	}
}

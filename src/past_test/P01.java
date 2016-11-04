package past_test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * coupang and company is coupang 이면 cg2, ad1, cy1, is1 이런식으로 단어집을 생성하기
 * 
 * @author leetaejun
 *
 */
public class P01 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		WordDictionary wd = new WordDictionary();
		while (true) {
			String sentence = scanner.nextLine();
			wd.insertSentence(sentence);
			wd.print();
		}
	}

	static class WordDictionary {
		private Map<String, Integer> wordMap;
		private List<String> exceptWordList;

		public WordDictionary() {
			this.wordMap = new HashMap<>();
			this.exceptWordList = new LinkedList<>(Arrays.asList(".", ",", "!", "@"));
		}

		public Map<String, Integer> getWordMap() {
			return wordMap;
		}

		private String preprocessingWord(String inputSentence) {
			if (inputSentence == null) {
				return null;
			}

			for (String exceptionWord : exceptWordList) {
				inputSentence = inputSentence.replace(exceptionWord, "");
			}

			return inputSentence;
		}

		public void insertSentence(String inputSentence) {
			inputSentence = preprocessingWord(inputSentence);
			if (inputSentence != null) {
				String[] words = inputSentence.split(" ");
				for (int i = 0; i < words.length; i++) {
					String word = words[i];
					if (word.length() > 1) {
						char[] wordCharArray = word.toCharArray();
						String createdKey = String.valueOf(wordCharArray[0])
								+ String.valueOf(wordCharArray[wordCharArray.length - 1]);
						if (wordMap.containsKey(createdKey)) {
							Integer countByCreatedKey = wordMap.get(createdKey);
							wordMap.put(createdKey, countByCreatedKey + 1);
						} else {
							wordMap.put(createdKey, 1);
						}
					}
				}
			}
		}

		public void print() {
			for (String stringKey : wordMap.keySet()) {
				System.out.println("단어 : " + stringKey + ", 카운트 : " + wordMap.get(stringKey));
			}
		}
	}
}

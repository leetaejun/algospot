package coupang2016_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P02 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int wordCount = scanner.nextInt();
		WordDictionary wd = new WordDictionary();
		for (int i = 0; i < wordCount; i++) {
			String inputWordAndCount = scanner.next();
			wd.insertWord(inputWordAndCount);
		}
		
		int combinationWordCount = scanner.nextInt();
		List<Set<String>> setOfList = new ArrayList<>();
		for (int i = 0; i < combinationWordCount; i++) {
			String inputCombinationWords = scanner.next();
			String[] inputCombinationWord = inputCombinationWords.split(",");
			
			if (setOfList.size() == 0) {
				Set<String> setOfString = new HashSet<>();
				for (int j = 0; j < inputCombinationWord.length; j++) {
					setOfString.add(inputCombinationWord[j]);
				}
				setOfList.add(setOfString);
			} else {
				for (Set<String> setOfString : setOfList) {
					StringBuilder sb = new StringBuilder();
					for (String value : setOfString) {
						sb.append(value);
					}
					
					boolean isContains = false;
					for (int j = 0; j < inputCombinationWord.length; j++) {
						if (sb.toString().contains(inputCombinationWord[j])) {
							isContains = true;
						}
					}
					for (int j = 0; isContains && j < inputCombinationWord.length; j++) {
						setOfString.add(inputCombinationWord[j]);
					}
				}
				/*
				if (!isContains) {
					Set<String> newSetOfString = new HashSet<>();
					for (int j = 0; j < inputCombinationWord.length; j++) {
						newSetOfString.add(inputCombinationWord[j]);
					}
					setOfList.add(newSetOfString);
				}
				*/
			}
		}
		
		for (int i = 0; i < setOfList.size(); i++) {
			Set<String> setOfString = setOfList.get(i);
			for (String string : setOfString) {
				System.out.println(string);
			}
		}
	}
	
	static class WordDictionary {
		private Map<String, Integer> wordMap;
		public WordDictionary() {
			this.wordMap = new HashMap<>();
		}
		
		public boolean insertWord(String input) {
			if (input == null) {
				return false;
			}
			
			String[] splitedInput = input.split(",");
			wordMap.put(splitedInput[0], Integer.parseInt(splitedInput[1]));
			
			return true;
		}
		
		public Map<String, Integer> getWordMap() {
			return wordMap;
		}
	}
	
	static class TJNode {
		private String keyData;
		private Integer countData;
		private TJNode nextNode;
		public TJNode(String keyData, Integer countData) {
			this.keyData = keyData;
			this.countData = countData;
			this.nextNode = null;
		}
		public String getKeyData() {
			return keyData;
		}
		public void setKeyData(String keyData) {
			this.keyData = keyData;
		}
		public Integer getCountData() {
			return countData;
		}
		public void setCountData(Integer countData) {
			this.countData = countData;
		}
		public TJNode getNextNode() {
			return nextNode;
		}
		public void setNextNode(TJNode nextNode) {
			this.nextNode = nextNode;
		}
	}
}

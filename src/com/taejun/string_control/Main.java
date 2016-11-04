package com.taejun.string_control;

public class Main {

	public static void main(String[] args) {
		System.out.println(StringControllerUtil.reverseString("i say hello world"));
		System.out.println(StringControllerUtil.reverseStringByWord("i say hello world"));
		System.out.println(StringControllerUtil.compressString("aaabbcabcaaa"));
		System.out.println(StringControllerUtil.compressString("i say hello worldd"));
		System.out.println(StringControllerUtil.removeStringByWord("i say hello world", "say"));
		System.out.println(StringControllerUtil.replaceStringByWord("i say hello say world", "say", "said"));
		System.out.println(StringControllerUtil.isUniqueCharacterInString("abcdefgc"));
	}
}

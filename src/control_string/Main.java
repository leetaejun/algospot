package control_string;

public class Main {

	public static void main(String[] args) {
		System.out.println(StringControllerUtil.reverseString("i say hello world"));
		System.out.println(StringControllerUtil.reverseStringByWord("i say hello world"));
		System.out.println(StringControllerUtil.compressString("aaabbcabcaaa"));
		System.out.println(StringControllerUtil.compressString("i say hello worldd"));
	}
}

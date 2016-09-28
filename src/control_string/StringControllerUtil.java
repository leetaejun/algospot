package control_string;

public class StringControllerUtil {
	// 들어온 문자열을 모두 뒤집는 함수
	public static String reverseString(String input) {
		if (input == null) {
			return null;
		}
		
		char[] inputCharArray = input.toCharArray();
		
		for (int i = 0; i < inputCharArray.length / 2; i++) {
			char temp = inputCharArray[i];
			inputCharArray[i] = inputCharArray[inputCharArray.length-i-1];
			inputCharArray[inputCharArray.length-i-1] = temp;
		}
		
		return String.valueOf(inputCharArray);
	}
	
	// ' '를 기준으로 문자열 뒤집기
	public static String reverseStringByWord(String input) {
		if (input == null) {
			return null;
		}
		
		String[] inputStrings = input.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = inputStrings.length-1; i >= 0; i--) {
			sb.append(inputStrings[i]).append(" ");
		}
		
		String result = (sb.length() == 0) ? "" : sb.substring(0, sb.length() - 1);
		
		return result;
	}
}

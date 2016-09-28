package control_string;

public class StringControllerUtil {
	/**
	 * 들어온 문자열을 모두 뒤집는 함수
	 * 
	 * @param input input은 String 타입으로 뒤집을 문자열을 넣어줍니다.
	 * @return input 문자열을 뒤집은 String 타입이 반환됩니다. ("i say hello world" -> "dlrow olleh yas i")
	 */
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
	
	/**
	 * ' '를 기준으로 문자열 뒤집기
	 * 
	 * @param input input은 String 타입으로 ' '을 기준으로 뒤집을 문자열을 넣어줍니다.
	 * @return input 문자열을 뒤집은 String 타입이 반환됩니다. ("i say hello world" -> "world hello say i")
	 */
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
	
	/**
	 * 문자열 압축하기
	 * 
	 * @param input input은 String 타입으로 압축할 문자열을 넣어줍니다. 
	 * @return input 문자열의 각 문자들의 중복된 개수를 표현하는 것으로 환합니다. ("aaabccbbaa" -> "a3b1c2b2a2")
	 */
	public static String compressString(String input) {
		if (input == null) {
			return null;
		} else if (input.length() == 0) {
			return "";
		}

		char[] inputCharArray = input.toCharArray();
		StringBuilder sb = new StringBuilder();
		char prevChar = inputCharArray[0];
		int count = 0;
		for (int i = 0; i < inputCharArray.length; i++) {
			if (prevChar == inputCharArray[i]) {
				count++;
			} else {
				sb.append(prevChar).append(String.valueOf(count));
				count = 1;
				prevChar = inputCharArray[i];
			}
		}
		sb.append(prevChar).append(count);
		
		return sb.toString();
	}
	
	/**
	 * 문자열에서 특정단어 지우기
	 * 
	 * @param input input은 String 타입으로 지울 대상이 되는 값을 넣어줍니다.
	 * @param target target은 String 타입으로 지울 단어를 넣어줍니다.
	 * @return input에서 target에 해당하는 값을 모두 지운 뒤의 String 값을 반환합니다.
	 */
	public static String removeStringByWord(String input, String target) {
		if (input == null) {
			return null;
		} else if (input.equals("")) {
			return "";
		}
		
		if (target == null || target.equals("")) {
			return input;
		}
		
		char[] inputCharArray = input.toCharArray();
		char[] targetCharArray = target.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(int inputCharIndex = 0; inputCharIndex < inputCharArray.length; inputCharIndex++) {
			int targetCharIndex = 0;
			for (int compareIndex = inputCharIndex; targetCharIndex < targetCharArray.length && compareIndex < inputCharArray.length; targetCharIndex++, compareIndex++) {
				if (targetCharArray[targetCharIndex] != inputCharArray[compareIndex]) {
					break;
				}
				
				if (targetCharIndex == targetCharArray.length - 1) {
					inputCharIndex = inputCharIndex + targetCharArray.length;
					break;
				}
			}
			sb.append(inputCharArray[inputCharIndex]);
		}
		
		return sb.toString();
	}
	
	/**
	 * 문자열에서 특정 단어 치환하기
	 * 
	 * @param input input은 String 타입으로 치환을 할 대상 문자열을 넣어줍니다.
	 * @param oldString oldString은 String 타입으로 문자열 중 바꿀 대상이 되는 문자열을 넣어줍니다.
	 * @param newString newString은 String 타입으로 oldString에서 바꿀 문자열을 넣어줍니다.
	 * @return input에서 oldString 대신 newString으로 바뀐 문자열을 반환합니다.
	 */
	public static String replaceStringByWord(String input, String oldString, String newString) {
		if (input == null) {
			return null;
		} else if (input.equals("")) {
			return "";
		}
		
		if (oldString == null || newString == null || oldString.equals("") || newString.equals("")) {
			return input;
		}
		
		char[] inputCharArray = input.toCharArray();
		char[] oldStringCharArray = oldString.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		
		for(int inputCharIndex = 0; inputCharIndex < inputCharArray.length; inputCharIndex++) {
			int targetCharIndex = 0;
			for (int compareIndex = inputCharIndex; targetCharIndex < oldStringCharArray.length && compareIndex < inputCharArray.length; targetCharIndex++, compareIndex++) {
				if (oldStringCharArray[targetCharIndex] != inputCharArray[compareIndex]) {
					break;
				}
				
				if (targetCharIndex == oldStringCharArray.length - 1) {
					inputCharIndex = inputCharIndex + oldStringCharArray.length;
					sb.append(newString);
					break;
				}
			}
			sb.append(inputCharArray[inputCharIndex]);
		}
		
		return sb.toString();
	}
	
	// 문자열에서 단어 개수 세기
}

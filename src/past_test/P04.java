package past_test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 문제 링크 : https://www.algospot.com/judge/problem/read/URI
 */

public class P04 {
	public static void main(String args[]) throws UnsupportedEncodingException {
		
		List<String> uriList = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		
		for(int i = 0; i < count; i++) {
			String before = scanner.next();
			uriList.add(URLDecoder.decode(before, "UTF-8"));
		}
		
		for(int i = 0; i < uriList.size(); i++) {
			System.out.println(uriList.get(i));
		}
	}
}

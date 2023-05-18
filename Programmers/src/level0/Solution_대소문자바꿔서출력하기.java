package level0;

import java.util.Scanner;

public class Solution_대소문자바꿔서출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a.length(); i++) {
			if (Character.isUpperCase(a.charAt(i))) {
				sb.append(Character.toLowerCase(a.charAt(i)));
			} else {
				sb.append(Character.toUpperCase(a.charAt(i)));
			}
		}
		System.out.println(sb.toString());
	}
}

package level0;

import java.util.Arrays;

public class Solution_인덱스바꾸기 {
	public static void main(String[] args) {
		String my_string = "I love you";
		int num1 = 3, num2 = 6;
		System.out.println(solution(my_string, num1, num2));
	}

	public static String solution(String my_string, int num1, int num2) {
		String answer = "";
		char[] my_char = my_string.toCharArray();
		char temp = my_char[num1];
		my_char[num1] = my_char[num2];
		my_char[num2] = temp;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_char.length; i++) {
			sb.append(my_char[i]);
		}
		answer = sb.toString();
		return answer;
	}

}

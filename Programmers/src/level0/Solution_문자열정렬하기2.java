package level0;

import java.util.Arrays;

public class Solution_문자열정렬하기2 {
	public static void main(String[] args) {
		String my_string = "heLLO";
		System.out.println(solution(my_string));
	}

	public static String solution(String my_string) {
		String answer = "";
		my_string = my_string.toLowerCase();
		char[] my_char = my_string.toCharArray();
		Arrays.sort(my_char);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_char.length; i++) {
			sb.append(my_char[i]);
		}
		answer = sb.toString();
		return answer;
	}

}

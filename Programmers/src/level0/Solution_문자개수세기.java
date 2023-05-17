package level0;

import java.util.Arrays;

public class Solution_문자개수세기 {
	public static void main(String[] args) {
		String my_string = "Programmers";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	public static int[] solution(String my_string) {
		int[] answer = new int[52];
		for (int i = 0; i < my_string.length(); i++) {
			char alpha = my_string.charAt(i);
			if (Character.isUpperCase(alpha)) {
				answer[alpha - 'A'] += 1;
			} else {
				answer[26 + alpha - 'a'] += 1;
			}
		}
		return answer;
	}

}

package level0;

import java.util.Arrays;

public class Solution_접미사배열 {
	public static void main(String[] args) {
		String my_string = "banana";
		System.out.println(Arrays.toString(solution(my_string)));
	}

	public static String[] solution(String my_string) {
		String[] answer = new String[my_string.length()];
		for (int i = my_string.length() - 1; i >= 0; i--) {
			answer[i] = my_string.substring(i, my_string.length());
		}
		Arrays.sort(answer);
		return answer;
	}

}

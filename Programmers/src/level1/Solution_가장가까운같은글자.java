package level1;

import java.util.Arrays;

public class Solution_가장가까운같은글자 {
	public static void main(String[] args) {
		String s = "foobar";
		System.out.println(Arrays.toString(solution(s)));
	}

	public static int[] solution(String s) {
		int[] answer = new int[s.length()];
		int[] alpha = new int[26];
		for (int i = 0; i < 26; i++) {
			alpha[i] = -1;
		}
		for (int i = 0; i < s.length(); i++) {
			int now = s.charAt(i) - 'a';
			if (alpha[now] == -1) {
				answer[i] = alpha[now];
			} else {
				answer[i] = i - alpha[now];
			}
			alpha[now] = i;
		}

		return answer;
	}

}

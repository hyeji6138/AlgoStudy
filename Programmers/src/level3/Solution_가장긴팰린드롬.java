package level3;

import java.util.Arrays;

public class Solution_가장긴팰린드롬 {
	public static void main(String[] args) {
		String s = "aaaa";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 1;

		for (int std = 0; std < s.length(); std++) {
			int size = Math.min(std, s.length() - std - 1);
			char[] charSet = new char[size + 1];
			for (int i = 0; i <= size; i++) {
				charSet[i] = s.charAt(std - i);
			}
			System.out.println(Arrays.toString(charSet));
			int len = 1;
			for (int i = 1; i <= size; i++) {
				if (s.charAt(std + i) != charSet[i]) {
					break;
				}
				len += 2;

			}
			answer = Math.max(answer, len);
			len = 0;
			for (int i = 0; i <= size; i++) {
				if (s.charAt(std + 1 + i) != charSet[i]) {
					break;
				}
				len += 2;
			}
			answer = Math.max(answer, len);
		}

		return answer;
	}

}

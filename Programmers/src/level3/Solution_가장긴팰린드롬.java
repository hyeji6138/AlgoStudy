package level3;

import java.util.Arrays;

public class Solution_가장긴팰린드롬 {
	public static void main(String[] args) {
		String s = "abcdcba";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 1;
		for (int i = 0; i < s.length(); i++) {
			// 홀수 길이 확인
			int start = i - 1, end = i + 1;
			int len = 1;
			while (true) {
				if (start < 0 || end >= s.length()) {
					break;
				}

				if (s.charAt(start) == s.charAt(end)) {
					start -= 1;
					end += 1;
					len += 2;
				} else {
					break;
				}
			}
			answer = Math.max(len, answer);
			// 짝수 길이 확인
			start = i;
			end = i + 1;
			len = 0;
			while (true) {
				if (start < 0 || end >= s.length()) {
					break;
				}

				if (s.charAt(start) == s.charAt(end)) {
					start -= 1;
					end += 1;
					len += 2;
				} else {
					break;
				}
			}
			answer = Math.max(len, answer);
		}
		return answer;
	}

}

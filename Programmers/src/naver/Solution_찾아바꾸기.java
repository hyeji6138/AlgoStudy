package naver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 2021.07.04 네이버웹툰 개발 챌린지 1차 코딩 테스트 (Back-End) 3번*/
public class Solution_찾아바꾸기 {
	public static void main(String[] args) {
		// aabcbcd, abc
		// aaaaabbbbb, ab
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 500000; i++) {
			sb.append("a");
		}
		for (int i = 0; i < 500000; i++) {
			sb.append("b");
		}
		System.out.println(solution_04(sb.toString(), "ab"));
	}

	public static int solution_04(String s, String t) {
		int result = 0;
		int[][] array = new int[t.length() + 1][s.length() + 1];
		int std = 1;
		for (int tIdx = 1; tIdx <= t.length(); tIdx++) {
			for (int sIdx = 1; sIdx <= s.length(); sIdx++) {
				if (t.charAt(tIdx - 1) == s.charAt(sIdx - 1)) {
					array[tIdx][sIdx] = array[tIdx - 1][sIdx - std] + 1;
					if (array[tIdx][sIdx] == t.length()) {
						std += t.length();
						result++;
					} else
						std = 1;
				}
			}
		}
		return result;
	}

	public static int solution_03(String s, String t) {
		int result = 0;
		for (int sIdx = 0; sIdx < s.length(); sIdx++) {
			boolean find = true;
			for (int tIdx = 0; tIdx < t.length(); tIdx++) {
				if (s.charAt(sIdx + tIdx) == t.charAt(tIdx)) continue;
				find = false;
				break;
			}
			if (find) {
				s = s.substring(0, sIdx) + s.substring(sIdx + t.length());
				sIdx = Math.max(-1, sIdx - t.length());
				result++;
				System.out.println(result);
			}
		}
		return result;
	}

	public static int solution_02(String s, String t) {
		int result = 0;
		String after = s;
		Pattern p = Pattern.compile(t);
		while (true) {
			if (after.indexOf(t) < 0) break;
			Matcher m = p.matcher(after);
			while (m.find()) {
				result++;
			}
			after = m.replaceAll("");
		}

		return result;
	}

	public static int solution_01(String s, String t) {
		int result = 0;
		String after = s;

		while (true) {
			if (after.replaceFirst(t, "").equals(after)) break;
			after = after.replaceFirst(t, "");
			result++;
		}

		return result;
	}
}

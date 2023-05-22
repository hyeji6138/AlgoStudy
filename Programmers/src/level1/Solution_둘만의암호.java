package level1;

public class Solution_둘만의암호 {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;
		System.out.println(solution(s, skip, index));
	}

	public static String solution(String s, String skip, int index) {
		String answer = "";
		boolean[] skipAlpha = new boolean[26];
		for (int i = 0; i < skip.length(); i++) {
			skipAlpha[skip.charAt(i) - 'a'] = true;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			for (int cnt = 0; cnt < index;) {
				idx = (idx + 1) % 26;
				if (!skipAlpha[idx]) {
					cnt += 1;
				}

			}
			sb.append((char) ('a' + idx));
		}
		answer = sb.toString();
		return answer;
	}

}

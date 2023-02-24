package level0;

public class Solution_한번만등장한문자 {
	public static void main(String[] args) {
		String s = "abcabcabcd";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
		int[] alphaCnt = new int[26];
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			alphaCnt[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < alphaCnt.length; i++) {
			if (alphaCnt[i] == 1) {
				sb.append((char) ('a' + i));
			}
		}
		answer = sb.toString();
		return answer;
	}

}

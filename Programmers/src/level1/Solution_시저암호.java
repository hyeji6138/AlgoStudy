package level1;

public class Solution_시저암호 {
	public static void main(String[] args) {
		System.out.println(solution("AB", 1));
	}

	public static String solution(String s, int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char alpha = s.charAt(i);
			if (alpha >= 'a' && alpha <= 'z') {
				if (alpha + n > 'z') sb.append((char) ('a' + (alpha + n) - 'z' - 1));
				else sb.append((char) (alpha + n));
			} else if (alpha >= 'A' && alpha <= 'Z') {
				if (alpha + n > 'Z') sb.append((char) ('A' + (alpha + n) - 'Z' - 1));
				else sb.append((char) (alpha + n));
			} else {
				sb.append(alpha);
			}
		}
		answer = sb.toString();
		return answer;
	}
}

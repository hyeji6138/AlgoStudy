package level1;

public class Solution_문자열다루기기본 {
	public static void main(String[] args) {
		System.out.println(solution("1234"));
	}

	public static boolean solution(String s) {
		boolean answer = true;
		if (s.length() != 4 && s.length() != 6) answer = false;
		else {
			for (char c : s.toCharArray()) {
				if (c < '0' || c > '9') {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}
}

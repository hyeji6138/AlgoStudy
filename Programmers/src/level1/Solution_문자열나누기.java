package level1;

public class Solution_문자열나누기 {
	public static void main(String[] args) {
		String s = "banana";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		char x = s.charAt(0);
		int xCnt = 0, cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (x == s.charAt(i)) {
				xCnt++;
			} else {
				cnt++;
			}

			if (xCnt == cnt) {
				answer++;
				xCnt = 0;
				cnt = 0;
				if (i + 1 < s.length()) {
					x = s.charAt(i + 1);
				}
			}
		}
		if (xCnt != cnt) {
			answer++;
		}
		return answer;
	}

}

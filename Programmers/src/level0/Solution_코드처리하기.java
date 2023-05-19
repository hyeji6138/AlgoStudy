package level0;

public class Solution_코드처리하기 {
	public static void main(String[] args) {
		String code = "abc1abc1abc";
		System.out.println(solution(code));
	}

	public static String solution(String code) {
		String answer = "";
		int mode = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < code.length(); i++) {
			if (mode == 0) {
				if (code.charAt(i) == '1') {
					mode = 1;
				} else if (i % 2 == 0) {
					sb.append(code.charAt(i));
				}
			} else {
				if (code.charAt(i) == '1') {
					mode = 0;
				} else if (i % 2 != 0) {
					sb.append(code.charAt(i));
				}
			}
		}
		if (sb.length() > 0) {
			answer = sb.toString();
		} else {
			answer = "EMPTY";
		}
		return answer;
	}

}

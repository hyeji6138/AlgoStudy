package level1;

public class Solution_숫자짝꿍 {
	public static void main(String[] args) {
		String X = "01";
		String Y = "00";
		System.out.println(solution(X, Y));
	}

	public static String solution(String X, String Y) {
		String answer = "";
		int[] xCnt = new int[10];
		int[] yCnt = new int[10];
		for (int i = 0; i < X.length(); i++) {
			xCnt[X.charAt(i) - '0']++;
		}
		for (int i = 0; i < Y.length(); i++) {
			yCnt[Y.charAt(i) - '0']++;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < Math.min(xCnt[i], yCnt[i]); j++) {
				sb.append(i);
			}
		}
		if (sb.length() == 0) {
			answer = "-1";
		} else if (sb.charAt(0) == '0') {
			answer = "0";
		} else {
			answer = sb.toString();
		}
		return answer;
	}

}

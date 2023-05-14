package level0;

public class Solution_수조작하기2 {
	public static void main(String[] args) {
		int[] log = { 0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1 };
		System.out.println(solution(log));
	}

	public static String solution(int[] numLog) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < numLog.length; i++) {
			if (Math.abs(numLog[i] - numLog[i - 1]) == 1) {
				if (numLog[i] > numLog[i - 1]) {
					sb.append("w");
				} else {
					sb.append("s");
				}
			} else {
				if (numLog[i] > numLog[i - 1]) {
					sb.append("d");
				} else {
					sb.append("a");
				}
			}
		}
		answer = sb.toString();
		return answer;
	}
}

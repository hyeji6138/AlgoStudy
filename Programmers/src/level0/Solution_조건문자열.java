package level0;

public class Solution_조건문자열 {
	public static void main(String[] args) {
		String ineq = "<";
		String eq = "=";
		int n = 20, m = 50;
		System.out.println(solution(ineq, eq, n, m));
	}

	public static int solution(String ineq, String eq, int n, int m) {
		int answer = 0;
		if (ineq.equals("<")) {
			if (eq.equals("=")) {
				answer = n <= m ? 1 : 0;
			} else {
				answer = n < m ? 1 : 0;
			}
		} else {
			if (eq.equals("=")) {
				answer = n >= m ? 1 : 0;
			} else {
				answer = n > m ? 1 : 0;
			}
		}
		return answer;
	}

}

package level1;

public class Solution_수박수박수 {
	public static void main(String[] args) {
		System.out.println(solution(3));
	}

	public static String solution(int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n / 2; i++) {
			sb.append("수박");
		}
		if (n % 2 == 1) sb.append("수");
		answer = sb.toString();
		return answer;
	}
}

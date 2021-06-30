package level1;

public class Solution_3진법뒤집기 {
	public static void main(String[] args) {
		System.out.println(solution(45));
	}

	public static int solution(int n) {
		int answer = 0;
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			sb.append(n % 3);
			n /= 3;
		}
		for (int i = 0; i < sb.length(); i++) {
			answer += Math.pow(3, sb.length() - 1 - i) * (sb.charAt(i) - '0');
		}
		return answer;
	}
}

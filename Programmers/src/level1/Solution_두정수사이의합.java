package level1;

public class Solution_두정수사이의합 {
	public static void main(String[] args) {
		System.out.println(solution(0, 0));
	}

	public static long solution(int a, int b) {
		long answer = 0;
		for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
			answer += i;
		}
		return answer;
	}

}

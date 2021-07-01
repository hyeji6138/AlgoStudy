package level1;

public class Solution_정수제곱근판별 {
	public static void main(String[] args) {
		System.out.println(solution(3));
	}

	public static long solution(long n) {
		long answer = 0;
		double sqrt = Math.sqrt(n);
		if (sqrt % 1 == 0) answer = (long) Math.pow(sqrt + 1, 2);
		else answer = -1;
		return answer;
	}
}

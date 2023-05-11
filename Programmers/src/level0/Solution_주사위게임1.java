package level0;

public class Solution_주사위게임1 {
	public static void main(String[] args) {
		int a = 3, b = 5;
		System.out.println(solution(a, b));
	}

	public static int solution(int a, int b) {
		int answer = 0;
		boolean is_a = isOdd(a);
		boolean is_b = isOdd(b);
		if (is_a && is_b) {
			answer = a * a + b * b;
		} else if (!is_a && !is_b) {
			answer = Math.abs(a - b);
		} else {
			answer = 2 * (a + b);
		}
		return answer;
	}

	public static boolean isOdd(int n) {
		return n % 2 != 0;
	}

}

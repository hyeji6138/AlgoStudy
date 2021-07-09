package level2;

public class Solution_예상대진표 {
	public static void main(String[] args) {
		System.out.println(solution(16, 12, 16));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;
		answer = test(n, a, b);
		return answer;
	}

	public static int test(int n, int a, int b) {
		if(n == 1) {
			return 1;
		}
		int cnt = 0;
		if ((a <= n / 2 && b <= n / 2) || (a > n / 2 && b > n / 2)) {
			cnt += test(n / 2, a / 2 + a % 2, b / 2 + b % 2);
		}
		return cnt;
	}
}

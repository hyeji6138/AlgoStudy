package level2;

public class Solution_2xn타일링 {
	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		if (n <= 2) {
			return n;
		}
		int[] sum = new int[n + 1];
		sum[1] = 1;
		sum[2] = 2;
		for (int i = 3; i <= n; i++) {
			sum[i] = (sum[i - 2] + sum[i - 1]) % 1000000007;
		}

		return sum[n];
	}

}

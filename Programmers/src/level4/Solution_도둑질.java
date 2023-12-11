package level4;

public class Solution_도둑질 {
	public static void main(String[] args) {
		int[] money = { 1, 10, 20, 4, 40 };
		System.out.println(solution(money));
	}

	static public int solution(int[] money) {
		int answer = 0;
		int N = money.length;
		int[][] dp = new int[2][N];
		dp[0][0] = 0;
		dp[0][1] = money[0];
		dp[1][0] = 0;
		dp[1][1] = money[1];
		for (int i = 2; i < N; i++) {
			dp[0][i] = Math.max(dp[0][i - 2] + money[i - 1], dp[0][i - 1]);
			dp[1][i] = Math.max(dp[1][i - 2] + money[i], dp[1][i - 1]);
		}
		answer = Math.max(dp[0][N - 1], dp[1][N - 1]);
		return answer;
	}

}

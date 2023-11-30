package level3;

public class Solution_거스름돈 {
	public static void main(String[] args) {
		int n = 5;
		int[] money = { 1, 2, 5 };
		System.out.println(solution(n, money));
	}

	static public int solution(int n, int[] money) {
		int answer = 0;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 0; i < money.length; i++) {
			for (int j = money[i]; j <= n; j++) {
				dp[j] += dp[j - money[i]];
			}
		}
		answer = dp[n];
		return answer;
	}

}

package level3;

public class Solution_스티커모으기2 {
	public static void main(String[] args) {
		int[] sticker = { 14 };

		System.out.println(solution(sticker));
	}

	public static int solution(int sticker[]) {
		int answer = 0;
		int[][] dp = new int[2][sticker.length];

		if (sticker.length == 1) {
			answer = sticker[0];
		} else {
			for (int i = 0; i < sticker.length - 1; i++) {
				if (i == 0) {
					dp[0][i] = sticker[i];
				} else if (i == 1) {
					dp[0][i] = Math.max(sticker[i], dp[0][i - 1]);
				} else {
					dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + sticker[i]);
				}
			}
			for (int i = 1; i < sticker.length; i++) {
				if (i == 1) {
					dp[1][i] = sticker[i];
				} else if (i == 2) {
					dp[1][i] = Math.max(sticker[i], dp[1][i - 1]);
				} else {
					dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + sticker[i]);
				}
			}
			answer = Math.max(dp[0][sticker.length - 2], dp[1][sticker.length - 1]);
		}
//		go(0, 0, sticker.length - 1, sticker);
//		go(0, 1, sticker.length, sticker);
		return answer;
	}

// 시간초과
//	public static void go(int sum, int cur, int num, int[] sticker) {
//		if (cur >= num) {
//			answer = Math.max(answer, sum);
//			return;
//		}
//		for (int i = cur; i < num; i++) {
//			go(sum + sticker[i], i + 2, num, sticker);
//		}
//	}

}

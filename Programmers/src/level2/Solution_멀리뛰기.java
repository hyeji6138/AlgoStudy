package level2;

public class Solution_멀리뛰기 {
	static long answer;

	public static void main(String[] args) {
		int n = 2000;
		System.out.println(solution(n));
	}

	public static long solution(int n) {
		long answer = 0;
		if (n == 1) return 1;
		else if (n == 2) return 2;
		int[] cnt = new int[n + 1];
		cnt[1] = 1;
		cnt[2] = 2;
		for (int i = 3; i <= n; i++) {
			cnt[i] = (cnt[i - 2] + cnt[i - 1]) % 1234567;
		}
		answer = cnt[n];
		return answer;
	}

}

package level2;

public class Solution_N개의최소공배수 {
	static int[][] cnt;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int answer = 1;
		cnt = new int[arr.length][101];
		for (int i = 0; i < arr.length; i++) {
			factorization(i, arr[i]);
		}
		for (int i = 1; i <= 100; i++) {
			int maxCnt = 0;
			for (int j = 0; j < arr.length; j++) {
				if (cnt[j][i] > maxCnt) {
					maxCnt = cnt[j][i];
				}
			}
			answer *= (int) Math.pow(i, maxCnt);
		}

		return answer;
	}

	public static void factorization(int idx, int n) {
		for (int i = (int) Math.sqrt(n); i >= 1; i--) {
			if (n % i == 0) {
				if (i != 1 && n / i != 1) {
					factorization(idx, i);
					factorization(idx, n / i);
				} else {
					cnt[idx][n / i]++;
				}
				break;
			}
		}

	}

}

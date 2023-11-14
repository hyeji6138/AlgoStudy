package level2;

public class Solution_시소짝꿍 {
	public static void main(String[] args) {
		int[] weights = { 100, 100, 100, 150, 150, 200, 300 };
		System.out.println(solution(weights));
	}

	public static long solution(int[] weights) {
		long answer = 0;
		long[] w = new long[901];
		for (int i = 0; i < weights.length; i++) {
			w[weights[i] - 100]++;
		}
		for (int i = 0; i < w.length; i++) {
			if (w[i] > 0) {
				if ((i + 100) * 2 - 100 < w.length) {
					answer += w[i] * w[(i + 100) * 2 - 100];
				}
				if ((i + 100) % 2 == 0 && (i + 100) * 3 / 2 - 100 < w.length) {
					answer += w[i] * w[(i + 100) * 3 / 2 - 100];
				}
				if ((i + 100) % 3 == 0 && (i + 100) * 4 / 3 - 100 < w.length) {
					answer += w[i] * w[(i + 100) * 4 / 3 - 100];
				}
				if (w[i] > 1) {
					answer += w[i] * (w[i] - 1) / 2;
				}
			}
		}

		return answer;
	}

}

package level2;

import java.util.Arrays;

public class Solution_n제곱배열자르기 {
	public static void main(String[] args) {
		int n = 4;
		int left = 7;
		int right = 14;
		System.out.println(Arrays.toString(solution(n, left, right)));
	}

	public static int[] solution(int n, long left, long right) {
		int[] answer = new int[(int) (right - left + 1)];
		int idx = 0;
		for (long i = left; i <= right; i++) {
			answer[idx++] = (int) Math.max(i / n + 1, i % n + 1);
		}

		return answer;
	}

}

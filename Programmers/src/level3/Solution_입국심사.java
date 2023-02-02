package level3;

import java.util.Arrays;

public class Solution_입국심사 {
	public static void main(String[] args) {
		int n = 8;
		int[] times = { 1, 9 };
		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);
		long left = 0;
		long right = (long) times[times.length - 1] * n;

		while (left <= right) {
			long cnt = 0; // mid 시간동안 감독관(times)이 처리할 수 있는 사람 수
			long mid = (left + right) / 2;
			for (int i = 0; i < times.length; i++) {
				cnt += mid / times[i]; // i번째 감독관이 mid 시간동안 처리할 수 있는 사람 수
			}
			if (cnt >= n) {
				answer = Math.min(answer, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}

}

package level2;

import java.util.Arrays;

public class Solution_양궁대회 {
	static int[] answer, array;
	static int[] minScore = { Integer.MAX_VALUE, 0 };
	static int diff;

	public static void main(String[] args) {
		int n = 1;
		int[] info = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(solution(n, info)));
	}

	public static int[] solution(int n, int[] info) {
		answer = new int[info.length];
		array = new int[info.length];
		go(0, 0, n, info);
		if (diff == 0) {
			answer = new int[1];
			answer[0] = -1;
		}
		return answer;
	}

	public static void go(int cnt, int cur, int n, int[] info) {
		if (cnt >= n) {
			int apeach = 0;
			int ryan = 0;
			int[] min = new int[2];
			for (int i = 0; i < info.length; i++) {
				if (info[i] < array[i]) {
					ryan += 10 - i;
				} else if (info[i] > 0) {
					apeach += 10 - i;
				}

				if (array[i] > 0) {
					min[0] = 10 - i;
					min[1] = array[i];
				}
			}
			if (diff < ryan - apeach || (diff == ryan - apeach
					&& (minScore[0] > min[0] || minScore[0] == min[0] && minScore[1] < min[1]))) {
				diff = ryan - apeach;
				minScore = min;
				for (int i = 0; i < info.length; i++) {
					answer[i] = array[i];
				}
			}
			return;
		}

		for (int i = cur; i < info.length; i++) {
			if (cnt + info[i] + 1 <= n) {
				array[i] = info[i] + 1;
				go(cnt + info[i] + 1, i + 1, n, info);
				array[i] = 0;
			} else {
				array[i] = n - cnt;
				go(n, i + 1, n, info);
				array[i] = 0;
			}
		}
	}

}

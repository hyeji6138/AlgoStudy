package level0;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_겹치는선분의길이 {
	public static void main(String[] args) {
		int[][] lines = { { 0, 10 }, { 11, 21 }, { 22, 32 } };
		System.out.println(solution(lines));
	}

	public static int solution(int[][] lines) {
		int answer = 0;
		Arrays.sort(lines, new MyComparator());
		int start = lines[0][0], end = lines[0][1];

		if (lines[1][0] >= end) { // 1,2 겹치는 부분 없음
			start = lines[1][0];
			end = lines[1][1];
		} else {
			answer += Math.min(lines[1][1], end) - lines[1][0];
			start = Math.min(lines[1][1], end);
			end = Math.max(lines[1][1], end);
		}

		if (lines[2][1] > start && lines[2][0] < end) { // 2, 3 겹치는 부분
			answer += Math.min(lines[2][1], end) - Math.max(start, lines[2][0]);
		}
		return answer;
	}

	static class MyComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}
}

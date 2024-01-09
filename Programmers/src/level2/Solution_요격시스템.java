package level2;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_요격시스템 {
	public static void main(String[] args) {
		int[][] targets = { { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 } };
		System.out.println(solution(targets));
	}

	static public int solution(int[][] targets) {
		int answer = 0;
		Arrays.sort(targets, new MySort());
		int point = -1;
		for (int i = 0; i < targets.length; i++) {
			if (point <= targets[i][0]) {
				point = targets[i][1];
				answer += 1;
			} else if (targets[i][1] < point) {
				point = targets[i][1];
			}
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}

}

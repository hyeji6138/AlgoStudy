package level3;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_인사고과 {
	public static void main(String[] args) {
		int[][] scores = { { 4, 0 }, { 2, 3 }, { 4, 4 }, { 2, 6 } };
		System.out.println(solution(scores));
	}

	static public int solution(int[][] scores) {
		int[] wanho = scores[0];
		Arrays.sort(scores, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
//		Arrays.sort(scores, new MySort()); // 뭐가 다른거지?
		int answer = 1;
		int maxScore = 0;
		for (int i = 0; i < scores.length; i++) {
			if (wanho[0] < scores[i][0] && wanho[1] < scores[i][1]) {
				return -1;
			}
			if (maxScore <= scores[i][1]) {
				maxScore = scores[i][1];
				if (scores[i][0] + scores[i][1] > wanho[0] + wanho[1]) {
					answer += 1;
				}
			}
			System.out.println(Arrays.toString(scores[i]) + " " + maxScore + " " + answer);
		}
		return answer;
	}

	static class MySort implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o2[0] - o1[0];
		}

	}

}

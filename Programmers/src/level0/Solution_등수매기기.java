package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_등수매기기 {
	public static void main(String[] args) {
		int[][] score = { { 80, 70 }, { 70, 80 }, { 30, 50 }, { 90, 100 }, { 100, 90 }, { 100, 100 }, { 10, 30 } };
		System.out.println(Arrays.toString(solution(score)));
	}

	public static int[] solution(int[][] score) {
		int[] answer = new int[score.length];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < score.length; i++) {
			int total = score[i][0] + score[i][1];
			list.add(new int[] { total, i });

		}
		Collections.sort(list, new MyComparator());
		int rank = 1;
		for (int i = 0; i < list.size(); i++) {
			int[] now = list.get(i);
			if (i > 0 && now[0] == list.get(i - 1)[0]) {
				answer[now[1]] = answer[list.get(i - 1)[1]];
			} else {
				answer[now[1]] = rank;
			}
			rank++;
		}
		return answer;
	}

	static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o2[0] - o1[0];
		}

	}

}

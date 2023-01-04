package level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_단속카메라 {
	public static void main(String[] args) {
		int[][] routes = { { -20, 15 }, { -20, -15 }, { -14, -5 }, { -18, -13 }, { -5, -3 } };
		System.out.println(solution(routes));
	}

	public static int solution(int[][] routes) {
		int answer = 0;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < routes.length; i++) {
			list.add(routes[i]);
		}
		Collections.sort(list, new MyComparator());
		int left = Integer.MIN_VALUE, right = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			int[] car = list.get(i);
			if (left <= car[0] && car[0] <= right) {
				left = car[0];
				if (car[1] < right) {
					right = car[1];
				}
			} else {
				answer++;
				left = car[0];
				right = car[1];
			}
		}
		return answer;
	}

	static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			if (o1[0] == o2[0]) {
				return o1[1] - o1[1];
			}
			return o1[0] - o2[0];
		}

	}

}

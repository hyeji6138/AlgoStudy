package level3;

import java.util.Arrays;
import java.util.Comparator;

class Solution_섬연결하기 {
	public static void main(String[] args) {
		int n = 6;
		int[][] costs = { { 0, 1, 5 }, { 0, 3, 2 }, { 0, 4, 3 }, { 1, 4, 1 }, { 3, 4, 10 }, { 1, 2, 2 }, { 2, 5, 3 },
				{ 4, 5, 4 } };
		System.out.println(solution(n, costs));
	}

	public static int solution(int n, int[][] costs) {
		int answer = 0;
		int[] union = new int[n];
		for (int i = 0; i < n; i++) {
			union[i] = i;
		}
		Arrays.sort(costs, new MyComparator());
		for (int i = 0; i < costs.length; i++) {
			if (union(costs[i][0], costs[i][1], union)) {
//				System.out.println(costs[i][0] + " " + costs[i][1] + " " + costs[i][2]);
				answer += costs[i][2];
			}
		}
		return answer;
	}

	static class MyComparator implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}

	}

	public static int findParent(int n, int[] union) {
		if (n == union[n]) {
			return n;
		}
		return findParent(union[n], union);
	}

	public static boolean union(int a, int b, int[] union) {
		a = findParent(a, union);
		b = findParent(b, union);

		if (a == b) {
			return false;
		}

		if (a <= b) {
			union[b] = a;
		} else {
			union[a] = b;
		}
		return true;

	}

}

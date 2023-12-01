package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_부대복귀 {
	public static void main(String[] args) {
		int n = 5;
		int[][] roads = { { 1, 2 }, { 1, 4 }, { 2, 4 }, { 2, 5 }, { 4, 5 } };
		int[] sources = { 1, 3, 5 };
		int destination = 5;
		System.out.println(Arrays.toString(solution(n, roads, sources, destination)));
	}

	static public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		int[] answer = new int[sources.length];
//		int[][] map = new int[n + 1][n + 1]; 배열 사용 시 메모리초과
//		for (int i = 0; i < roads.length; i++) {
//			map[roads[i][0]][roads[i][1]] = 1;
//			map[roads[i][1]][roads[i][0]] = 1;
//		}
		List<List<Integer>> map = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++) {
			map.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < roads.length; i++) {
			map.get(roads[i][0]).add(roads[i][1]);
			map.get(roads[i][1]).add(roads[i][0]);
		}

		int[] len = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			len[i] = Integer.MAX_VALUE;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(destination);
		len[destination] = 0;
//		while (!queue.isEmpty()) {
//			int now = queue.poll();
//
//			for (int i = 1; i <= n; i++) {
//				if (map[now][i] == 1 && len[now] + 1 < len[i]) {
//					len[i] = len[now] + 1;
//					queue.add(i);
//				}
//			}
//		}
		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < map.get(now).size(); i++) {
				int next = map.get(now).get(i);
				if (len[now] + 1 < len[next]) {
					len[next] = len[now] + 1;
					queue.add(next);
				}
			}
		}
		for (int i = 0; i < sources.length; i++) {
			if (len[sources[i]] == Integer.MAX_VALUE) {
				answer[i] = -1;
			} else {
				answer[i] = len[sources[i]];
			}
		}
		return answer;
	}

}

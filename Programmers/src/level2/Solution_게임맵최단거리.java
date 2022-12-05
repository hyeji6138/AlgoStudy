package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_게임맵최단거리 {
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		int[][] maps = { { 1, 1 }, { 0, 1 } };
		System.out.println(solution(maps));
	}

	public static int solution(int[][] maps) {
		int answer = 0;
		int[] point = { maps.length - 1, maps[0].length - 1 };
		boolean[][] visit = new boolean[maps.length][maps[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(point);
		visit[point[0]][point[1]] = true;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] p = queue.poll();

				for (int d = 0; d < 4; d++) {
					int ni = p[0] + di[d];
					int nj = p[1] + dj[d];

					if (ni >= 0 && ni < maps.length && nj >= 0 && nj < maps[0].length && maps[ni][nj] == 1
							&& !visit[ni][nj]) {
						visit[ni][nj] = true;
						queue.add(new int[] { ni, nj });
					}
				}
			}
			answer++;
			if (visit[0][0]) {
				break;
			}
		}
		if (visit[0][0]) {
			return answer + 1;
		}

		return -1;
	}

}

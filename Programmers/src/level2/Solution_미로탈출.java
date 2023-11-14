package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_미로탈출 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
	static Point start, lever, exit;
	static int[][] map;
	static int N, M;

	public static void main(String[] args) {
		String[] maps = { "SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE" };
		System.out.println(solution(maps));
	}

	public static int solution(String[] maps) {
		int answer = 0;
		N = maps.length;
		M = maps[0].length();
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char ch = maps[i].charAt(j);
				if (ch == 'S') {
					start = new Point(i, j);
				} else if (ch == 'L') {
					lever = new Point(i, j);
				} else if (ch == 'E') {
					exit = new Point(i, j);
				} else if (ch == 'X') {
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
			}
		}

		int toLever = go(start, lever);
		int toExit = go(lever, exit);
		if (toLever < 0 || toExit < 0) {
			answer = -1;
		} else {
			answer = toLever + toExit;
		}
		return answer;
	}

	public static int go(Point start, Point end) {
		Queue<Point> queue = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		boolean pos = false;
		int step = 0;
		queue.add(start);
		visit[start.i][start.j] = true;
		while (!queue.isEmpty() && !pos) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Point now = queue.poll();
				if (now.i == end.i && now.j == end.j) {
					pos = true;
					break;
				}

				for (int d = 0; d < di.length; d++) {
					int ni = now.i + di[d];
					int nj = now.j + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 1 && !visit[ni][nj]) {
						queue.add(new Point(ni, nj));
						visit[ni][nj] = true;
					}
				}
			}
			if (!pos) {
				step += 1;
			}
		}
		if (!pos) {
			return -1;
		}
		return step;
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}

package level1;

import java.util.Arrays;

public class Solution_공원산책 {
	static int N, M;
	static int[] di = { 0, 0, 1, -1 }, dj = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		String[] park = { "SOO", "OXX", "OOO" };
		String[] routes = { "E 2", "S 2", "W 1" };
		System.out.println(Arrays.toString(solution(park, routes)));
	}

	static public int[] solution(String[] park, String[] routes) {
		int[] answer = {};
		N = park.length;
		M = park[0].length();
		int[][] map = new int[N][M];
		int[] robot = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char ch = park[i].charAt(j);
				if (ch == 'S') {
					robot[0] = i;
					robot[1] = j;
				} else if (ch == 'X') {
					map[i][j] = 1;
				}
			}
		}
		for (int i = 0; i < routes.length; i++) {
			String[] route = routes[i].split(" ");
			int step = Integer.parseInt(route[1]);
			int d = 0;
			if (route[0].equals("E")) {
				d = 0;
			} else if (route[0].equals("W")) {
				d = 1;
			} else if (route[0].equals("S")) {
				d = 2;
			} else {
				d = 3;
			}

			int ni = robot[0];
			int nj = robot[1];
			boolean pos = true;
			for (int s = 0; s < step; s++) {
				ni += di[d];
				nj += dj[d];
				if (ni < 0 || ni >= N || nj < 0 || nj >= M || map[ni][nj] == 1) {
					pos = false;
					break;
				}
			}

			if (pos) {
				robot[0] = ni;
				robot[1] = nj;
			}
		}
		answer = robot;
		return answer;
	}

}

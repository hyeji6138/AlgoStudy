package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_3055 {
	static int R, C;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Queue<int[]> dochi = new LinkedList<>();
		Queue<int[]> water = new LinkedList<>();

		boolean[][] dochiVisit = new boolean[R][C];
		boolean[][] waterVisit = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					dochiVisit[i][j] = true;
					dochi.add(new int[] { i, j });
				} else if (map[i][j] == '*') {
					waterVisit[i][j] = true;
					water.add(new int[] { i, j });
				}
			}
		}
		// ============================================
		int time = 0;
		boolean exit = false;
		while (true) {
			int size = water.size();

			for (int s = 0; s < size; s++) {
				int[] point = water.poll();

				for (int d = 0; d < di.length; d++) {
					int ni = point[0] + di[d];
					int nj = point[1] + dj[d];

					if (ni >= 0 && ni < R && nj >= 0 && nj < C && !waterVisit[ni][nj] && map[ni][nj] != 'X' && map[ni][nj] != 'D') {
						waterVisit[ni][nj] = true;
						water.add(new int[] { ni, nj });
						map[ni][nj] = '*';
					}
				}
			}

			size = dochi.size();

			for (int s = 0; s < size; s++) {
				int[] point = dochi.poll();

				for (int d = 0; d < di.length; d++) {
					int ni = point[0] + di[d];
					int nj = point[1] + dj[d];

					if (ni >= 0 && ni < R && nj >= 0 && nj < C && !dochiVisit[ni][nj] && !waterVisit[ni][nj] && map[ni][nj] != 'X') {
						if (map[ni][nj] == 'D') {
							exit = true;
						} else {
							dochiVisit[ni][nj] = true;
							dochi.add(new int[] { ni, nj });
							map[ni][nj] = 'S';
						}
					}
				}
			}
			if (exit || dochi.isEmpty()) break;
			time++;
		}
		if(exit) {
			System.out.println(time + 1);
		}else {
			System.out.println("KAKTUS");
		}
	}
	
	public static void printArray() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}

package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17142 { // 연구소3
	static int N, M, answer;
	static int[][] map;
	static List<int[]> virus;
	static int[] select, di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virus = new ArrayList<int[]>();
		select = new int[M];
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				}
			}
		}
		// ===============입력끝=====================
		if (check(map)) System.out.println(0);
		else {
			comb(0, 0);
			if(answer == Integer.MAX_VALUE) System.out.println(-1);
			else System.out.println(answer);
		}
	}

	public static void comb(int cnt, int cur) {
		if (cnt == M) {
			int[][] newMap = copyMap(map);
			Queue<int[]> q = new LinkedList<int[]>();
			for (int i = 0; i < M; i++) {
				int[] v = virus.get(select[i]);
				q.add(v);
				newMap[v[0]][v[1]] = 3;
			}
			int time = 1;
			boolean full = false;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int[] now = q.poll();
					for (int d = 0; d < 4; d++) {
						int ni = now[0] + di[d];
						int nj = now[1] + dj[d];

						if (ni >= 0 && ni < N && nj >= 0 && nj < N && newMap[ni][nj] != 1 && newMap[ni][nj] != 3) {
							q.add(new int[] { ni, nj });
							newMap[ni][nj] = 3;
						}
					}
				}
				if (check(newMap)) {
					full = true;
					break;
				}
				time++;
			}
			if(full) answer = Math.min(answer, time);
			return;
		}

		for (int i = cur; i < virus.size(); i++) {
			select[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	public static boolean check(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
}

package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17406 {
	static int N, M, K, answer;
	static int[] array;
	static int[][] map, order;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;
		map = new int[N + 1][M + 1];
		order = new int[K][3];
		visit = new boolean[K];
		array = new int[K];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ===========================입력 끝========================
		perm(0);
		System.out.println(answer);
	}

	public static void perm(int cnt) {
		if (cnt == K) {
			int[][] newMap = copyMap(map);
			for (int i = 0; i < K; i++) {
				int r = order[array[i]][0];
				int c = order[array[i]][1];
				int s = order[array[i]][2];

				for (int j = 0; j < s; j++) {
					rotate(newMap, r - s + j, c - s + j, r + s - j, c + s - j);
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= N; i++) {
				int sum = 0;
				for (int j = 1; j <= M; j++) {
					sum += newMap[i][j];
				}
				min = Math.min(min, sum);
			}
			answer = Math.min(answer, min);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visit[i]) {
				visit[i] = true;
				array[cnt] = i;
				perm(cnt + 1);
				visit[i] = false;
			}
		}
	}

	public static void rotate(int[][] map, int si, int sj, int ei, int ej) {
		int temp = map[si][sj];

		for (int i = si; i < ei; i++) {
			map[i][sj] = map[i + 1][sj];
		}
		for (int j = sj; j < ej; j++) {
			map[ei][j] = map[ei][j + 1];
		}
		for (int i = ei; i > si; i--) {
			map[i][ej] = map[i - 1][ej];
		}
		for (int j = ej; j > sj; j--) {
			map[si][j] = map[si][j - 1];
		}

		map[si][sj + 1] = temp;
	}

	public static int[][] copyMap(int[][] map) {
		int[][] newMap = new int[map.length][map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
}

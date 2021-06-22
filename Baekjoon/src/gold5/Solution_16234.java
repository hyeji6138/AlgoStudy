package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16234 { // 인구 이동
	static int N, L, R, answer;
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };// 우하좌상
	static boolean[][] visit, selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// =================입력 끝========================
		boolean go = false;
		Queue<int[]> q = new LinkedList<int[]>();
		int sum, cnt;
		while (true) {
			go = false;
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visit[i][j] && check(map, i, j)) {
						sum = cnt = 0;
						selected = new boolean[N][N];
						q.add(new int[] { i, j });
						visit[i][j] = true;
						selected[i][j] = true;
						sum += map[i][j];
						cnt++;
						while (!q.isEmpty()) {
							int[] now = q.poll();

							for (int d = 0; d < 4; d++) {
								int ni = now[0] + di[d];
								int nj = now[1] + dj[d];
								if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj] && !selected[ni][nj]) {
									int sub = Math.abs(map[now[0]][now[1]] - map[ni][nj]);
									if (sub >= L && sub <= R) {
										go = true;
										selected[ni][nj] = true;
										visit[ni][nj] = true;
										q.add(new int[] { ni, nj });
										cnt++;
										sum += map[ni][nj];
									}
								}
							}
						}
						q.add(new int[] { i, j });
						map[i][j] = sum / cnt;
						selected[i][j] = false;
						while (!q.isEmpty()) {
							int[] now = q.poll();

							for (int d = 0; d < 4; d++) {
								int ni = now[0] + di[d];
								int nj = now[1] + dj[d];
								if (ni >= 0 && ni < N && nj >= 0 && nj < N && selected[ni][nj]) {
									q.add(new int[] { ni, nj });
									selected[ni][nj] = false;
									map[ni][nj] = sum / cnt;
								}
							}
						}
					}
				}
			}
			if(!go) break;
			else answer++;
			q.clear();
		}
		System.out.println(answer);
	}
	
	public static boolean check(int[][] map, int i, int j) {
		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
				int sub = Math.abs(map[i][j] - map[ni][nj]);
				if(sub >= L && sub <= R) return true;
			}
		}
		return false;
	}

}

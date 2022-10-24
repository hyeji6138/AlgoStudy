package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17141 {
	static int N, M, answer;
	static int[] dx = { -1, 1, 0, 0 }, dy = { 0, 0, -1, 1 }, select; // 상하좌우
	static int[][] lab;
	static List<int[]> pointList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 연구소 크리
		M = Integer.parseInt(st.nextToken()); // 바이러스 개수
		lab = new int[N][N]; // 연구소
		select = new int[M];
		pointList = new LinkedList<>();
		// 연구실 상태 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2) {
					pointList.add(new int[] { i, j });
				}
			}
		}
		answer = Integer.MAX_VALUE;
		comb(0, 0, pointList.size());
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	public static void comb(int cnt, int cur, int num) { // cnt = 뽑아야 하는 자리 수, num = 현재 위치
		if (cnt == M) {
			Queue<int[]> pointQueue = new LinkedList<>();
			boolean[][] visit = new boolean[N][N];// 방문 체크
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (lab[i][j] == 1) {
						visit[i][j] = true;
					}
				}
			}

			for (int i = 0; i < M; i++) {// 바이러스 자리 지정
				int[] point = pointList.get(select[i]);
				pointQueue.add(point);
				visit[point[0]][point[1]] = true;
			}

			int time = 0;
			while (!pointQueue.isEmpty()) {
				int size = pointQueue.size();

				for (int i = 0; i < size; i++) {
					int[] point = pointQueue.poll();
					int x = point[0];
					int y = point[1];

					if (lab[x][y] != 1) {
						for (int d = 0; d < 4; d++) { // 상하좌우 탐색
							int di = x + dx[d];
							int dj = y + dy[d];
							if (di >= 0 && di < N && dj >= 0 && dj < N && !visit[di][dj]) {
								// 좌표가 연구실 범위 안에 있고 아직 방문하지 않았을 때
								visit[di][dj] = true;
								pointQueue.add(new int[] { di, dj });
							}
						}
					}
				}
				time++;
			}

			if (check(visit)) {
				answer = Math.min(answer, time - 1);
			}
			return;
		}

		for (int i = cur; i < num; i++) {
			select[cnt] = i;
			comb(cnt + 1, i + 1, num);
		}
	}

	public static boolean check(boolean[][] array) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!array[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}

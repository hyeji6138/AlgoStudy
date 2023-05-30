package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_23288 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 }; // 진행방향(동남서북), (시계방향 회전 : +1, 반시계방향회전 : -1)
	static int[][] dice = { { 0, 2, 0 }, { 4, 1, 3 }, { 0, 5, 0 }, { 0, 6, 0 } };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int answer = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] p = { 0, 0 };
		int d = 0;
		for (int k = 0; k < K; k++) {
			int npi = p[0] + di[d];
			int npj = p[1] + dj[d];
			if (!rangeCheck(npi, npj)) { // 현재 방향으로 이동 가능한지 검사
				d = (d + 2) % 4;
			}
			// 이동
			p[0] += di[d];
			p[1] += dj[d];
			moveDice(d); // 주사위 변화

			// 다음 이동방향 결정
			if (dice[3][1] > map[p[0]][p[1]]) {
				d = (d + 1) % 4;
			} else if (dice[3][1] < map[p[0]][p[1]]) {
				d = (4 + (d - 1)) % 4;
			}

			// 점수 획득
			boolean[][] visit = new boolean[N][M];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { p[0], p[1] });
			int score = 1;
			visit[p[0]][p[1]] = true;

			while (!q.isEmpty()) {
				int[] now = q.poll();
				for (int i = 0; i < di.length; i++) {
					int ni = now[0] + di[i];
					int nj = now[1] + dj[i];
					if (rangeCheck(ni, nj) && !visit[ni][nj] && map[ni][nj] == map[now[0]][now[1]]) {
						q.add(new int[] { ni, nj });
						visit[ni][nj] = true;
						score += 1;
					}
				}
			}
			answer += map[p[0]][p[1]] * score;
		}
		System.out.println(answer);
	}

	public static boolean rangeCheck(int i, int j) {
		return i >= 0 && i < N && j >= 0 && j < M;
	}

	public static void moveDice(int d) {
		int pre, next;
		switch (d) {
		case 0: // 동
			pre = dice[3][1];
			for (int i = 0; i < dice[1].length; i++) {
				next = dice[1][i];
				dice[1][i] = pre;
				pre = next;
			}
			dice[3][1] = pre;
			break;
		case 1: // 남
			pre = dice[0][1];
			for (int i = 1; i < dice.length; i++) {
				next = dice[i][1];
				dice[i][1] = pre;
				pre = next;
			}
			dice[0][1] = pre;
			break;
		case 2: // 서
			pre = dice[3][1];
			for (int i = dice[1].length - 1; i >= 0; i--) {
				next = dice[1][i];
				dice[1][i] = pre;
				pre = next;
			}
			dice[3][1] = pre;
			break;
		case 3:// 북
			pre = dice[dice.length - 1][1];
			for (int i = dice.length - 2; i >= 0; i--) {
				next = dice[i][1];
				dice[i][1] = pre;
				pre = next;
			}
			dice[dice.length - 1][1] = pre;
			break;
		default:
			break;
		}
	}

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}

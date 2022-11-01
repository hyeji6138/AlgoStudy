package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17822 {
	static int N, M, T;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			// x의 배수 원판 d 방향으로 k번 회전
			for (int i = 1; i * x <= N; i++) {
				for (int j = 0; j < k; j++) {
					rotate(map[(i * x) - 1], d);
				}
			}
			if (!remove()) {
				calculate();
			}
		}
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer += map[i][j];
			}
		}

		System.out.println(answer);
	}

	public static void rotate(int[] array, int d) {
		if (d == 0) { // 시계방향
			int pre = array[0], next = array[1];
			for (int i = 0; i < M - 1; i++) {
				next = array[i + 1];
				array[i + 1] = pre;
				pre = next;
			}
			array[0] = pre;
		} else { // 반시계방향
			int pre = array[M - 1], next = array[M - 2];
			for (int i = M - 1; i > 0; i--) {
				next = array[i - 1];
				array[i - 1] = pre;
				pre = next;
			}
			array[M - 1] = pre;
		}
	}

	public static boolean remove() {
		boolean[][] visit = new boolean[N][M];
		boolean check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] != 0) {
					Queue<int[]> queue = new LinkedList<>();
					queue.add(new int[] { i, j });
					visit[i][j] = true;
					boolean rm = false;
					while (!queue.isEmpty()) {
						int[] point = queue.poll();

						// 인접 탐색
						for (int d = 0; d < di.length; d++) {
							int ni = point[0] + di[d];
							int nj = point[1] + dj[d] < 0 ? M - 1 : point[1] + dj[d] >= M ? 0 : point[1] + dj[d];
							if (ni >= 0 && ni < N && nj >= 0 && nj < M && !visit[ni][nj] && map[ni][nj] == map[i][j]) {
								map[ni][nj] = 0;
								visit[ni][nj] = true;
								rm = true;
								queue.add(new int[] { ni, nj });
							}

						}
					}
					if (rm) {
						map[i][j] = 0;
						check = true;
					}
				}
			}
		}
		return check;
	}

	public static void calculate() {
		float avg = 0;
		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				avg += map[i][j];
				if (map[i][j] != 0) {
					num++;
				}
			}
		}
		avg = avg / num;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					if (map[i][j] > avg) {
						map[i][j]--;
					} else if (map[i][j] < avg) {
						map[i][j]++;
					}
				}
			}
		}

	}

//	public static void printArray() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//	}

}

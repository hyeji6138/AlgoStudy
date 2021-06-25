package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_16235 { // 나무 재테크
	static int N, M, K;
	static int[] di = { -1, -1, 0, 1, 1, 1, 0, -1 }, dj = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 12시부터 시계방향
	static int[][] A, nut;
	static PriorityQueue<Integer>[][] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		A = new int[N + 1][N + 1];
		nut = new int[N + 1][N + 1];
		tree = new PriorityQueue[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				nut[i][j] = 5;
				tree[i][j] = new PriorityQueue<Integer>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int age = Integer.parseInt(st.nextToken());
			tree[x][y].add(age);
		}
		// ==================입력 끝==========================
		for (int t = 0; t < K; t++) {
			springAndSummer();
			fallAndWinter();
		}
		int answer = countTree();
		System.out.println(answer);
	}

	public static int countTree() {
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sum += tree[i][j].size();
			}
		}
		return sum;
	}

	public static void fallAndWinter() {
		int[][] add = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				Iterator<Integer> iterator = tree[i][j].iterator();
				while(iterator.hasNext()) {
					int age = iterator.next();
					if (age % 5 == 0) {
						for (int d = 0; d < 8; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];

							if (ni >= 1 && ni <= N && nj >= 1 && nj <= N) {
								add[ni][nj]++;
							}
						}
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 0; k < add[i][j]; k++) {
					tree[i][j].add(1);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nut[i][j] += A[i][j];
			}
		}
	}

	public static void springAndSummer() {
		int[][] add = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int size = tree[i][j].size();
				int[] ages = new int[size];
				int idx = 0;
				for (int s = 0; s < size; s++) {
					int age = tree[i][j].poll();
					if (nut[i][j] >= age) {
						nut[i][j] -= age;
						ages[idx++] = age + 1;
					} else {
						add[i][j] += (age / 2);
					}
				}
				for (int s = 0; s < idx; s++) {
					tree[i][j].add(ages[s]);
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				nut[i][j] += add[i][j];
			}
		}
	}
}

package gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1005 { // ACM Craft
	static int T, N, K, W;
	static int[] delay;
	static boolean[][] graph;
	static long[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			delay = new int[N + 1];
			graph = new boolean[N + 1][N + 1];
			sum = new long[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				delay[i] = Integer.parseInt(st.nextToken());
				sum[i] = -1;
			}

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());

				graph[s][e] = true;
			}
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());

			// =====================입력 끝==============================

			go(W);
			System.out.println(sum[W]);
		}
	}

	public static void go(int n) {
		long maxDelay = 0;
		for (int i = 1; i <= N; i++) {
			if (graph[i][n]) {
				if (sum[i] == -1) {
					go(i);
				}
				maxDelay = Math.max(maxDelay, sum[i]);
			}
		}
		sum[n] = maxDelay + delay[n];
	}

}

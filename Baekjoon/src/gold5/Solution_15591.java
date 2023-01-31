package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_15591 {
	static int N, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		int[][] video = new int[N + 1][N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			video[a][b] = v;
			video[b][a] = v;
		}

//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= N; j++) {
//				System.out.print(link[i][j] + " ");
//			}
//			System.out.println();
//		}

		for (int t = 0; t < Q; t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int answer = 0;
			Queue<int[]> queue = new LinkedList<>();
			boolean[] visit = new boolean[N + 1];
			visit[start] = true;
			queue.add(new int[] { start, Integer.MAX_VALUE });

			while (!queue.isEmpty()) {
				int[] p = queue.poll();
				if (p[1] >= k) {
					if (Integer.MAX_VALUE != p[1]) {
						answer++;
					}
					for (int i = 1; i <= N; i++) {
						if (!visit[i] && video[p[0]][i] != 0) {
							visit[i] = true;
							queue.add(new int[] { i, Math.min(p[1], video[p[0]][i]) });
						}
					}
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

}

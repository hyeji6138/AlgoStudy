package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] w = new int[N + 1];
		int[] v = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			w[i + 1] = Integer.parseInt(st.nextToken());
			v[i + 1] = Integer.parseInt(st.nextToken());
		}

		int[][] d = new int[N + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= K; j++) {
				if (j < w[i]) {
					d[i][j] = d[i - 1][j];
				} else {
					d[i][j] = Math.max(v[i] + d[i - 1][j - w[i]], d[i - 1][j]);
				}
			}
		}
		System.out.println(d[N][K]);

	}

}

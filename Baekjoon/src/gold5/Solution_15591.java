package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

		List<int[]>[] USADO = new ArrayList[N + 1]; // 연결 상태 저장할 때 배열 사용 시 시간초과
		for (int i = 1; i <= N; i++) {
			USADO[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			USADO[p].add(new int[] { q, r });
			USADO[q].add(new int[] { p, r });
		}

		for (int t = 0; t < Q; t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int answer = 0;

			Queue<Integer> queue = new LinkedList<>();
			boolean[] visit = new boolean[N + 1];
			visit[start] = true;
			queue.add(start);

			while (!queue.isEmpty()) {
				int v = queue.poll();
				for (int[] line : USADO[v]) {
					if (!visit[line[0]] && k <= line[1]) {
						answer += 1;
						visit[line[0]] = true;
						queue.add(line[0]);
					}
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}

}

package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2644 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		boolean[][] link = new boolean[n + 1][n + 1];
		boolean[] visit = new boolean[n + 1];
		int[] target = new int[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int start, end;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());

			link[start][end] = true;
			link[end][start] = true;
		}
		// =======================================================

		Queue<Integer> queue = new LinkedList<>();
		queue.add(target[0]);
		visit[target[0]] = true;

		boolean find = false;
		int time = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int now = queue.poll();
				if (now == target[1]) {
					find = true;
					break;
				}
				for (int i = 1; i <= n; i++) {
					if (link[now][i] && !visit[i]) {
						queue.add(i);
						visit[i] = true;
					}
				}
			}
			if(find) {
				break;
			}
			time++;
		}
		if (find) {
			System.out.println(time);
		} else {
			System.out.println(-1);
		}

	}

}

package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_16946 {
	static int N, M;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }, cnt; // 상하좌우
	static int[][] map, group;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		group = new int[N][M];
		cnt = new int[N * M];

		for (int i = 0; i < N; i++) {
			char[] value = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = value[j] - '0';
			}
		}

		// =========================================================
		int group_num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Queue<int[]> queue = new LinkedList<>();
				if (group[i][j] == 0 && map[i][j] == 0) {
					int count = 1;
					queue.add(new int[] { i, j });
					group[i][j] = group_num;
					while (!queue.isEmpty()) {
						int[] point = queue.poll();

						for (int d = 0; d < di.length; d++) {
							int ni = point[0] + di[d];
							int nj = point[1] + dj[d];

							if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0 && group[ni][nj] == 0) {
								count += 1;
								group[ni][nj] = group_num;
								queue.add(new int[] {ni, nj});
							}
						}
					}

					cnt[group_num - 1] = count;
					group_num += 1;
				}
			}
		}
		
		StringBuffer sb = new StringBuffer();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					for (int d = 0; d < di.length; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni >= 0 && ni < N && nj >= 0 && nj < M && group[ni][nj] != 0) {
							set.add(group[ni][nj]);
						}
					}
					Iterator<Integer> iterSet = set.iterator();
					while (iterSet.hasNext()) {
						map[i][j] += cnt[iterSet.next() - 1];
					}
				}
				sb.append(map[i][j] % 10);
				set.clear();
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}
}

package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_16236 { // 아기 상어
	static int N, M, answer;
	static int[][] map;
	static int[] di = { -1, 0, 0, 1 }, dj = { 0, -1, 1, 0 }, shark; // 상좌우하

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		shark = new int[4]; // [0] : i위치, [1] : j위치, [2] : 상어크기, [3] : 먹은 물고기 수
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					shark[2] = 2;
					map[i][j] = 0;
				}
			}
		}
		// =====================입력 끝=========================
		Queue<int[]> q = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][N];
		q.add(new int[] { shark[0], shark[1] });
		visit[shark[0]][shark[1]] = true;
		int[] eat = {-1,-1};
		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();
				for (int d = 0; d < 4; d++) {
					int ni = now[0] + di[d];
					int nj = now[1] + dj[d];

					if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj]) {
						if (map[ni][nj] == 0 || map[ni][nj] == shark[2]) { // 크기가 같은 물고기자리면 지나갈 수 있음
							q.add(new int[] { ni, nj });
							visit[ni][nj] = true;
						} else if (map[ni][nj] != 0 && map[ni][nj] < shark[2]) { // 크기가 작은 물고기 먹을 수 있음
							if((eat[0] == -1 && eat[1] == -1) || (eat[0] > ni) || (eat[0] == ni && eat[1] > nj)) {
								eat[0] = ni;
								eat[1] = nj;
								break;
							}
						}
					}
				}
			}
			time++;
			if(eat[0] != -1 && eat[1] != -1) { //물고기 먹을 거 있음
				map[eat[0]][eat[1]] = 0;
				shark[3]++;
				if (shark[3] == shark[2]) {
					shark[2]++;
					shark[3] = 0;
				}
				shark[0] = eat[0];
				shark[1] = eat[1];
				
				eat[0] = -1;
				eat[1] = -1;
				
				q.clear();
				visit = new boolean[N][N];
				q.add(new int[] {shark[0], shark[1]});
				visit[shark[0]][shark[1]] = true;
				answer += time;
				time = 0;
			}
		}
		System.out.println(answer);
	}

}

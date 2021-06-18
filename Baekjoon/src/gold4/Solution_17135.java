package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17135 { // 캐슬 디펜스
	static int N, M, D, answer;
	static int[][] map;
	static int[] archerLoc;
	static int[] di = { 0, -1, 0 }, dj = { -1, 0, 1 }; // 좌상우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		archerLoc = new int[3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ==================입력 끝=====================
		selectLoc(0, 0);
		System.out.println(answer);
	}
	
	public static int kill(int[][] map) { // 한 턴에 죽이는 적 수 리턴
		int cnt = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		int[][] kill = new int[3][2];
		for (int i = 0; i < 3; i++) {
			q.add(new int[] { N, archerLoc[i] });
			boolean selected = false;
			boolean[][] visit = new boolean[N][M];
			int dist = 1;
			kill[i][0] = kill[i][1] = -1;
			while (!q.isEmpty()) {
				int size = q.size();
				for (int s = 0; s < size; s++) {
					int[] now = q.poll();
					
					for(int d = 0; d<3;d++) {
						int ni = now[0]+di[d];
						int nj = now[1]+dj[d];
						
						if(ni >= 0 && ni < N && nj >= 0 && nj < M && !visit[ni][nj]) {
							if(map[ni][nj] == 1) {
								kill[i][0] = ni;
								kill[i][1] = nj;
								selected = true;
								break;
							}else {
								q.add(new int[] { ni, nj });
								visit[ni][nj] = true;
							}
						}
					}
					if(selected) break;
				}
				dist++;
				if(selected) break;
				if(dist > D) break;
			}
			q.clear();
		}
		
		for(int i=0;i<3;i++) {
			if(kill[i][0] != -1 && kill[i][1] != -1 && map[kill[i][0]][kill[i][1]] == 1) {
				map[kill[i][0]][kill[i][1]] = 0;
				cnt++;
			}
		}
		return cnt;
	}
	
	public static void selectLoc(int cnt, int idx) {
		if (cnt == 3) {
			// 시뮬
			int[][] newMap = copyMap(map);
			int killCnt = 0;
			while(!check(newMap)) {
				killCnt += kill(newMap);
				down(newMap);
			}
			
			answer = Math.max(answer, killCnt);
			return;
		}

		for (int i = idx; i < M; i++) {
			archerLoc[cnt] = i;
			selectLoc(cnt + 1, i + 1);
		}
	}
	
	public static int[][] copyMap(int[][] map){
		int[][] newMap = new int[N+1][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				newMap[i][j] = map[i][j];
			}
		}
		return newMap;
	}
	
	public static boolean check(int[][] map) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	public static void down(int[][] map) {
		for(int i = N-1;i>=1;i--) {
			for(int j=0;j<M;j++) {
				map[i][j] = map[i-1][j];
			}
		}
		for(int j=0;j<M;j++) {
			map[0][j] = 0;
		}
	}
}

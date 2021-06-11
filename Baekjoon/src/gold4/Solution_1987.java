package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1987 { // 알파벳
	static int R, C, answer;
	static char[][] map;
	static boolean[] alpha;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		alpha = new boolean[26];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		// ============입력 끝==============
		alpha[map[0][0]-'A'] = true;
		go(0,0,1);
		System.out.println(answer);
	}

	public static void go(int i, int j, int cnt) {
		for (int d = 0; d < 4; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(ni >= 0 && ni < R && nj >= 0 && nj < C && !alpha[map[ni][nj]-'A']) {
				alpha[map[ni][nj]-'A'] = true;
				go(ni,nj, cnt+1);
				alpha[map[ni][nj]-'A'] = false;
			}
		}
		answer = Math.max(answer, cnt);
	}

}

package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_18428 {
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };
	static int N;
	static char[][] map;
	static boolean answer;
	static int[] select;
	static List<int[]> tc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		answer = false;
		tc = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					tc.add(new int[] { i, j });
				}
			}
		}
		select = new int[3];
		comb(0, 0);
		if(answer) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}

	public static void comb(int cnt, int cur) {
		if (cnt == 3) {
			if(bfs()) {
				answer = true;
			}
			return;
		}
		for (int i = cur; i < N * N; i++) {
			if (!answer && map[i / N][i % N] == 'X') {
				select[cnt] = i;
				comb(cnt + 1, i + 1);
			}
		}
	}

	public static boolean bfs() {
		char[][] temp = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < select.length; i++) {
			temp[select[i] / N][select[i] % N] = 'O';
		}
		for (int i = 0; i < tc.size(); i++) {
			int[] t = tc.get(i);

			for (int d = 0; d < di.length; d++) {
				int ni = t[0] + di[d];
				int nj = t[1] + dj[d];

				while (ni >= 0 && ni < N && nj >= 0 && nj < N) {
					if (temp[ni][nj] == 'O') {
						break;
					} else if (temp[ni][nj] == 'S') {
						return false;
					} else {
						ni = ni + di[d];
						nj = nj + dj[d];
					}
				}
			}
		}
		return true;
	}
}

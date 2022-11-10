package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1079 {
	static int N, eunjin, answer;
	static int[] guilty;
	static int[][] R;
	static boolean[] killed;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		killed = new boolean[N];
		R = new int[N][N];
		guilty = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			guilty[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				R[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		eunjin = Integer.parseInt(br.readLine());
		answer = 0;
		// ==================================================================
		kill(0, N);
		System.out.println(answer);
	}

	public static void kill(int cnt, int num) {
		if (killed[eunjin] || (num == 1 && !killed[eunjin])) { // 게임 끝
			answer = Math.max(answer, cnt);
			return;
		}

		if (num % 2 == 0) { // 밤 (아무나 죽임)
			for (int i = 0; i < N; i++) {
				if (!killed[i] && i != eunjin) {
					killed[i] = true;
					// 유죄지수 변경
					for (int j = 0; j < N; j++) {
						guilty[j] = guilty[j] + R[i][j];
					}

					kill(cnt + 1, num - 1); // 밤 횟수만 카운팅
					killed[i] = false;
					for (int j = 0; j < N; j++) {
						guilty[j] = guilty[j] - R[i][j];
					}
				}
			}
		} else { // 낮 (죄 많은 사람 죽임)
			int max = Integer.MIN_VALUE, maxIdx = -1;
			for (int i = 0; i < N; i++) {
				if (!killed[i] && max < guilty[i]) {
					max = guilty[i];
					maxIdx = i;
				}
			}
			killed[maxIdx] = true;
			kill(cnt, num - 1); // 밤 횟수만 카운팅
			killed[maxIdx] = false;
		}
	}

}

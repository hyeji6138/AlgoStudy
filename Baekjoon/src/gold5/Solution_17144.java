package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_17144 { // 미세먼지 안녕!
	static int R, C, T;
	static int[][] A;
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }, robot; // 상하좌우

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		A = new int[R][C];
		robot = new int[2];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				if (A[i][j] == -1) {
					robot[idx++] = i;
				}
			}
		}
		// ================입력 끝============================
		for (int i = 0; i < T; i++) {
			diffusion();
			removeTop();
			removeBottom();
		}
		int answer = cntDust();
		System.out.println(answer);
	}
	
	public static int cntDust() {
		int cnt = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (A[i][j] != -1) cnt += A[i][j];
			}
		}
		return cnt;
	}
	
	public static void removeTop() {
		// 위쪽 반시계방향
		for (int i = robot[0]; i > 0; i--) {
			A[i][0] = A[i - 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			A[0][j] = A[0][j + 1];
		}
		for (int i = 0; i < robot[0]; i++) {
			A[i][C - 1] = A[i + 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			A[robot[0]][j] = A[robot[0]][j - 1];
		}
		A[robot[0]][0] = -1;
		A[robot[0]][1] = 0;

	}

	public static void removeBottom() {
		// 아래쪽 시계방향
		for (int i = robot[1]; i < R - 1; i++) {
			A[i][0] = A[i + 1][0];
		}
		for (int j = 0; j < C - 1; j++) {
			A[R - 1][j] = A[R - 1][j + 1];
		}
		for (int i = R - 1; i > robot[0]; i--) {
			A[i][C - 1] = A[i - 1][C - 1];
		}
		for (int j = C - 1; j > 1; j--) {
			A[robot[1]][j] = A[robot[1]][j - 1];
		}
		A[robot[1]][0] = -1;
		A[robot[1]][1] = 0;

	}

	public static void diffusion() {
		int[][] addA = new int[R][C];
		int[][] subA = new int[R][C];
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(A[i][j] > 0) {
					int cnt = 0;
					for (int d = 0; d < 4; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];

						if (ni >= 0 && ni < R && nj >= 0 && nj < C && A[ni][nj] != -1) {
							addA[ni][nj] += (A[i][j] / 5);
							cnt++;
						}
					}
					subA[i][j] = cnt * (A[i][j] / 5);
				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				A[i][j] = A[i][j] + addA[i][j] - subA[i][j];
			}
		}
	}

}

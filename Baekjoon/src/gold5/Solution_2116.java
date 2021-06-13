package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2116 { // 주사위 쌓기
	static int N, answer;
	static int[][] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dice = new int[N][6]; // 0-5, 1-3, 2-4
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ===================입력 끝=====================

		for (int i = 0; i < 6; i++) { // 1번 주사위 아랫면
			boolean[][] select = new boolean[N][6];
			int topIndex = findTopIndex(i);
			select[0][i] = select[0][topIndex] = true;
			int sum = findMax(dice[0], select[0]);

			for (int j = 1; j < N; j++) {
				int top = dice[j - 1][topIndex];
				int bottomIndex = findNumIndex(dice[j], top);
				topIndex = findTopIndex(bottomIndex);
				
				select[j][bottomIndex] = select[j][topIndex] = true;
				sum += findMax(dice[j], select[j]);
			}
			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}

	public static int findNumIndex(int[] dice, int n) {
		for (int i = 0; i < 6; i++) {
			if (dice[i] == n) return i;
		}
		return -1;
	}

	public static int findMax(int[] dice, boolean[] select) {
		int max = 0;
		for (int i = 0; i < 6; i++) {
			if (!select[i]) max = Math.max(max, dice[i]);
		}
		return max;
	}

	public static int findTopIndex(int n) {
		if (n == 0) {
			return 5;
		} else if (n == 1) {
			return 3;
		} else if (n == 2) {
			return 4;
		} else if (n == 3) {
			return 1;
		} else if (n == 4) {
			return 2;
		} else {
			return 0;
		}
	}

}

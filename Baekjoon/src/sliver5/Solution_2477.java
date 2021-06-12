package sliver5;

import java.util.Scanner;

public class Solution_2477 { // 참외밭
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		int[][] field = new int[6][2];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 2; j++) {
				field[i][j] = sc.nextInt();
			}
		}
		sc.close();
		// ===========입력끝==================
		int maxWidth = 0, maxHeight = 0;
		for (int i = 0; i < 6; i++) {
			if (field[i][0] <= 2) maxWidth = Math.max(maxWidth, field[i][1]);
			else maxHeight = Math.max(maxHeight, field[i][1]);
		}
		int minWidth = 0, minHeight = 0;
		for (int i = 0; i < 6; i++) {
			if (field[i][0] <= 2 && maxHeight == field[(i + 1) % 6][1] + field[(i + 5) % 6][1]) {
				minWidth = field[i][1];
			} else if (field[i][0] > 2 && maxWidth == field[(i + 1) % 6][1] + field[(i + 5) % 6][1]) {
				minHeight = field[i][1];
			}
		}
		int answer = (maxWidth * maxHeight - minHeight * minWidth) * K;
		System.out.println(answer);
	}

}

package level3;

public class Solution_파괴되지않은건물 {
	public static void main(String[] args) {
		int[][] board = { { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 }, { 5, 5, 5, 5, 5 } };
		int[][] skill = { { 1, 0, 0, 3, 4, 4 }, { 1, 2, 0, 2, 3, 2 }, { 2, 1, 0, 3, 1, 2 }, { 1, 0, 1, 3, 3, 1 } };
		System.out.println(solution(board, skill));
	}

	static public int solution(int[][] board, int[][] skill) { //누적합
		int answer = 0;
		int n = board.length, m = board[0].length;
		int[][] sum = new int[n + 1][m + 1];
		for (int i = 0; i < skill.length; i++) {
			int r1 = skill[i][1], c1 = skill[i][2];
			int r2 = skill[i][3], c2 = skill[i][4];
			if (skill[i][0] == 1) {
				sum[r1][c1] -= skill[i][5];
				sum[r1][c2 + 1] += skill[i][5];
				sum[r2 + 1][c1] += skill[i][5];
				sum[r2 + 1][c2 + 1] -= skill[i][5];
			} else {
				sum[r1][c1] += skill[i][5];
				sum[r1][c2 + 1] -= skill[i][5];
				sum[r2 + 1][c1] -= skill[i][5];
				sum[r2 + 1][c2 + 1] += skill[i][5];
			}
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				sum[i][j] += sum[i][j - 1];
			}
		}
		for (int i = 0; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				sum[j][i] += sum[j - 1][i];
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] + sum[i][j] > 0) {
					answer += 1;
				}
			}
		}
		return answer;
	}

//	static public int solution(int[][] board, int[][] skill) {
//		int answer = 0;
//		for (int i = 0; i < skill.length; i++) {
//			for (int r = skill[i][1]; r <= skill[i][3]; r++) {
//				for (int c = skill[i][2]; c <= skill[i][4]; c++) {
//					if (skill[i][0] == 1) {
//						board[r][c] -= skill[i][5];
//					} else {
//						board[r][c] += skill[i][5];
//					}
//				}
//			}
//		}
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board[i].length; j++) {
//				if (board[i][j] > 0) {
//					answer += 1;
//				}
//			}
//		}
//		return answer;
//	}

}

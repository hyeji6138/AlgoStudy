package level2;

public class Solution_혼자서하는틱택토 {
	public static void main(String[] args) {
		String[] board = { "OOO", "XOX", "XXO" };
		System.out.println(solution(board));
	}

	static public int solution(String[] board) {
		int answer = 1;
		int oCnt = 0, xCnt = 0;
		int oLineCnt = 0, xLineCnt = 0;
		for (int i = 0; i < 3; i++) {
			if (board[i].equals("OOO")) {
				oLineCnt += 1;
			} else if (board[i].equals("XXX")) {
				xLineCnt += 1;
			}

			if (board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
				if (board[0].charAt(i) == 'O') {
					oLineCnt += 1;
				} else if (board[0].charAt(i) == 'X') {
					xLineCnt += 1;
				}
			}
			for (int j = 0; j < 3; j++) {
				if (board[i].charAt(j) == 'O') {
					oCnt += 1;
				} else if (board[i].charAt(j) == 'X') {
					xCnt += 1;
				}
			}
		}

		if (board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
			if (board[1].charAt(1) == 'O') {
				oLineCnt += 1;
			} else if (board[1].charAt(1) == 'X') {
				xLineCnt += 1;
			}
		}
		if (board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
			if (board[1].charAt(1) == 'O') {
				oLineCnt += 1;
			} else if (board[1].charAt(1) == 'X') {
				xLineCnt += 1;
			}
		}
		if (oCnt < xCnt || oCnt > xCnt + 1) {
			answer = 0;
		} else if (oLineCnt > 0 && (oCnt == xCnt || oLineCnt > 2)) {
			answer = 0;
		} else if (xLineCnt > 0 && (xCnt < oCnt || xLineCnt > 1)) {
			answer = 0;
		}
		return answer;
	}
}

package level1;

public class Solution_PCCE기출9번이웃한칸 {
	public static void main(String[] args) {
		String[][] board = { { "blue", "red", "orange", "red" }, { "red", "red", "blue", "orange" },
				{ "blue", "orange", "red", "red" }, { "orange", "orange", "red", "blue" } };
		int h = 1, w = 1;
		System.out.println(solution(board, h, w));
	}

	static public int solution(String[][] board, int h, int w) {
		int answer = 0;
		int[] dh = { 0, 1, -1, 0 };
		int[] dw = { 1, 0, 0, -1 };
		int n = board.length;
		for (int i = 0; i < dh.length; i++) {
			int h_check = h + dh[i];
			int w_check = w + dw[i];
			if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
				if (board[h][w].equals(board[h_check][w_check])) {
					answer += 1;
				}
			}
		}
		return answer;
	}

}

package level0;

import java.util.Arrays;

public class Solution_캐릭터의좌표 {
	static int[] di = { 0, 0, -1, 1 }, dj = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		String[] keyinput = { "left", "right", "up", "right", "right" };
		int[] board = { 11, 11 };
		System.out.println(Arrays.toString(solution(keyinput, board)));
	}

	public static int[] solution(String[] keyinput, int[] board) {
		int[] answer = { 0, 0 };
		int n = board[0] / 2, m = board[1] / 2;
		for (int i = 0; i < keyinput.length; i++) {
			int d = -1;
			if (keyinput[i].equals("up")) {
				d = 0;
			} else if (keyinput[i].equals("down")) {
				d = 1;
			} else if (keyinput[i].equals("left")) {
				d = 2;
			} else {
				d = 3;
			}

			int ni = answer[0] + di[d];
			int nj = answer[1] + dj[d];

			if (ni >= -1 * n && ni <= n && nj >= -1 * m && nj <= m) {
				answer[0] = ni;
				answer[1] = nj;
			}
		}
		return answer;
	}

}

package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_리코쳇로봇 {
	static int N, M;
	static int[] di = { 0, 1, 0, -1 }, dj = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		String[] board = { "...D..R", ".D.G...", "....D.D", "D....D.", "..D...." };
		System.out.println(solution(board));
	}

	static public int solution(String[] board) {
		int answer = 0;
		N = board.length;
		M = board[0].length();
		int[][] map = new int[N][M];
		int[] robot = new int[2];
		int[] goal = new int[2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char ch = board[i].charAt(j);
				if (ch == 'D') {
					map[i][j] = 1;
				} else if (ch == 'R') {
					robot[0] = i;
					robot[1] = j;
				} else if (ch == 'G') {
					goal[0] = i;
					goal[1] = j;
				}
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visit = new boolean[N][M][di.length];
		boolean pos = false;
		int step = 0;
		queue.add(robot);
		while (!queue.isEmpty() && !pos) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				int[] now = queue.poll();
				if (now[0] == goal[0] && now[1] == goal[1]) {
					pos = true;
					break;
				}

				for (int d = 0; d < di.length; d++) {
					int ni = now[0];
					int nj = now[1];
					while (ni + di[d] >= 0 && ni + di[d] < N && nj + dj[d] >= 0 && nj + dj[d] < M) {
						if (map[ni + di[d]][nj + dj[d]] != 1) {
							ni += di[d];
							nj += dj[d];
						} else {
							break;
						}
					}
					
					if ((now[0] != ni || now[1] != nj) && !visit[ni][nj][d]) {
						queue.add(new int[] { ni, nj });
						visit[ni][nj][d] = true;
					}

				}
			}
			if (!pos) step += 1;
		}
		if (!pos) {
			answer = -1;
		} else {
			answer = step;
		}
		return answer;
	}

}

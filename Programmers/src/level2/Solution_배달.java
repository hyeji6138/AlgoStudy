package level2;

public class Solution_배달 {
	public static void main(String[] args) {
		int N = 6, K = 2;
		int[][] road = { { 1, 2, 1 }, { 2, 3, 1 }, { 3, 4, 1 }, { 4, 5, 1 }, { 5, 6, 1 }, { 1, 6, 1 } };
		System.out.println(solution(N, road, K));
	}

	public static int solution(int N, int[][] road, int K) {
		int answer = 0;
		int[][] len = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) {
					len[i][j] = 0;
				} else {
					len[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		for (int i = 0; i < road.length; i++) {
			len[road[i][0]][road[i][1]] = Math.min(len[road[i][0]][road[i][1]], road[i][2]);
			len[road[i][1]][road[i][0]] = Math.min(len[road[i][1]][road[i][0]], road[i][2]);
		}
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if ((len[i][k] != Integer.MAX_VALUE && len[k][j] != Integer.MAX_VALUE)
							&& len[i][j] > len[i][k] + len[k][j]) {
						len[i][j] = len[i][k] + len[k][j];
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				System.out.print(len[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i <= N; i++) {
			if (len[1][i] <= K) {
				answer++;
			}
		}
		return answer;
	}

}

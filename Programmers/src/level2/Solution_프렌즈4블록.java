package level2;

public class Solution_프렌즈4블록 {
	static int[] di = { 0, 1, 1 }, dj = { 1, 1, 0 };

	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		System.out.println(solution(m, n, board));
	}

	public static int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		while (true) {
			char[][] nextMap = removeBlock(m, n, map);
			if (answer == countRemovedBlock(nextMap)) {
				break;
			}
			answer = countRemovedBlock(nextMap);
			downBlock(nextMap);
			map = nextMap;

		}

		return answer;
	}

	public static char[][] removeBlock(int m, int n, char[][] map) {
		char[][] newMap = new char[m][n];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] != '-') {
					boolean boom = true;
					for (int d = 0; d < 3; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						if (ni < 0 || ni >= m || nj < 0 || nj >= n || map[ni][nj] != map[i][j]) {
							boom = false;
							break;
						}
					}
					if (boom) {
						newMap[i][j] = '-';
						for (int d = 0; d < 3; d++) {
							int ni = i + di[d];
							int nj = j + dj[d];
							newMap[ni][nj] = '-';
						}
					} else {
						if (newMap[i][j] != '-') {
							newMap[i][j] = map[i][j];
						}
					}
				} else {
					newMap[i][j] = '-';
				}
			}
		}
		return newMap;
	}

	public static int countRemovedBlock(char[][] map) {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == '-') {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void downBlock(char[][] map) {
		for (int i = map.length - 1; i >= 0; i--) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != '-') {
					int target = i + 1;
					while (target < map.length) {
						if (map[target][j] != '-') {
							break;
						}
						target++;
					}
					if (target - 1 < map.length && map[target - 1][j] == '-') {
						map[target - 1][j] = map[i][j];
						map[i][j] = '-';
					}
				}
			}
		}
	}

	public static void printArray(char[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}

package level2;

public class Solution_방문길이 {
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우
	static boolean[][][] visit;

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		System.out.println(solution(dirs));
	}

	public static int solution(String dirs) {
		int answer = 0;
		int[] point = { 5, 5 };
		visit = new boolean[11][11][4];
		for (int i = 0; i < dirs.length(); i++) {
			char step = dirs.charAt(i);
			if (step == 'U') {
				if (go(point, 0)) {
					answer++;
				}
			} else if (step == 'D') {
				if (go(point, 1)) {
					answer++;
				}
			} else if (step == 'L') {
				if (go(point, 2)) {
					answer++;
				}
			} else {
				if (go(point, 3)) {
					answer++;
				}
			}
		}
		return answer;
	}

	public static boolean go(int[] point, int d) {
		boolean result = false;
		int ni = point[0] + di[d];
		int nj = point[1] + dj[d];

		if (ni >= 0 && ni < 11 && nj >= 0 && nj < 11) {
			if (!visit[ni][nj][d] && !visit[point[0]][point[1]][d % 2 == 0 ? d + 1 : d - 1]) {
				visit[ni][nj][d] = true;
				visit[point[0]][point[1]][d % 2 == 0 ? d + 1 : d - 1] = true;
				result = true;
			}
			point[0] = ni;
			point[1] = nj;
		}
		return result;
	}

}

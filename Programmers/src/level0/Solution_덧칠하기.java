package level0;

public class Solution_덧칠하기 {
	public static void main(String[] args) {
		int n = 4, m = 1;
		int[] section = { 1, 2, 3, 4 };
		System.out.println(solution(n, m, section));
	}

	public static int solution(int n, int m, int[] section) {
		int answer = 0;
		boolean[] wall = new boolean[n];
		for (int i = 0; i < section.length; i++) {
			wall[section[i] - 1] = true;
		}

		for (int i = 0; i < n;) {
			if (wall[i]) {
				if (i + m < n) {
					for (int j = i; j < i + m; j++) {
						wall[j] = false;
					}
					i += m;
				} else {
					for (int j = i; j < n; j++) {
						wall[j] = false;
					}
					i = n;
				}
				answer += 1;
			} else {
				i += 1;
			}
		}

		return answer;
	}

}

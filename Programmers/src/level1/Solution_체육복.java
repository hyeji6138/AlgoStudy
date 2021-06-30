package level1;

public class Solution_체육복 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 }, reserve = { 3 };
		System.out.println(solution(n, lost, reserve));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] std = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			std[i] = 1;
		}
		for (int i = 0; i < lost.length; i++) {
			std[lost[i]] -= 1;
		}
		for (int i = 0; i < reserve.length; i++) {
			std[reserve[i]] += 1;
		}

		for (int i = 1; i <= n; i++) {
			if (std[i] > 0) {
				answer++;
			} else {
				if (i - 1 >= 1 && std[i - 1] > 1) {
					std[i - 1]--;
					answer++;
				} else if (i + 1 <= n && std[i + 1] > 1) {
					std[i + 1]--;
					answer++;
				}
			}
		}
		return answer;
	}

}

package level2;

public class Solution_숫자의표현 {
	public static void main(String[] args) {
		int n = 15;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0, j = 0;
			while (sum < n) {
				sum += i + j;
				if (sum == n) {
					answer++;
					break;
				}
				j++;
			}
		}
		return answer;
	}

}

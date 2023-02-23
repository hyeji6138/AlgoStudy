package level0;

public class Solution_합성수찾기 {
	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int num = 4; num <= n; num++) {
			int cnt = 0;
			for (int i = 1; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					cnt += 1;
					if (num / i != i) {
						cnt += 1;
					}
				}
			}
			if (cnt >= 3) {
				answer++;
			}
		}
		return answer;
	}

}

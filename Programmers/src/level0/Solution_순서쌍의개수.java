package level0;

public class Solution_순서쌍의개수 {
	public static void main(String[] args) {
		int n = 100;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (i * i == n) {
				answer += 1;
			} else if (n % i == 0) {
				answer += 2;
			}
		}
		return answer;
	}

}

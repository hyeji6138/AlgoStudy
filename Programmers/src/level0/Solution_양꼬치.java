package level0;

public class Solution_양꼬치 {
	public static void main(String[] args) {
		int n = 10, k = 3;
		System.out.println(solution(n, k));
	}

	public static int solution(int n, int k) {
		int answer = 0;
		answer = 12000 * n + (k - n / 10) * 2000;
		return answer;
	}

}

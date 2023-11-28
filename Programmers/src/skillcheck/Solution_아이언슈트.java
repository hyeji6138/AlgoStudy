package skillcheck;

public class Solution_아이언슈트 {
	public static void main(String[] args) {
		int n = 1000000000;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				ans += 1;
				n = (n - 1) / 2;
			}
		}
		return ans;
	}
}

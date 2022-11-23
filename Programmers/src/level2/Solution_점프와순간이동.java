package level2;

public class Solution_점프와순간이동 {
	public static void main(String[] args) {
		int n = 1000000000;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int ans = 0;
		if (n == 1) return 1;
		if (n % 2 == 1) {
			ans = solution(n / 2) + 1;
		} else {
			ans = solution(n / 2);
		}
		return ans;
	}

}

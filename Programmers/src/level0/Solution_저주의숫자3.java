package level0;

public class Solution_저주의숫자3 {
	public static void main(String[] args) {
		int n = 100;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		int answer = 1;
		for (int i = 1; i <= n; answer++) {
			if (answer % 3 == 0) {
				continue;
			} else {
				int temp = answer;
				boolean check = true;
				while (temp > 0) {
					if (temp % 10 == 3) {
						check = false;
						break;
					}
					temp /= 10;
				}
				if (!check) {
					continue;
				}
			}
			i++;
		}
		return answer - 1;
	}

}

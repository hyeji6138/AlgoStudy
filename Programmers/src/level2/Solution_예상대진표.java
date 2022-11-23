package level2;

public class Solution_예상대진표 {
	public static void main(String[] args) {
		System.out.println(solution(1024, 1, 899));
	}

	public static int solution(int n, int a, int b) {
		int answer = 0;
		while (true) {
			answer++;
			System.out.println(a + " " + b);
			if (Math.abs(a - b) == 1 && Math.max(a, b) / 2 - 1 == Math.min(a, b) / 2) {
				break;
			}
			a = nextNumber(a);
			b = nextNumber(b);
		}
		return answer;
	}

	public static int nextNumber(int n) {
		if (n % 2 == 0) {
			return n / 2;
		} else {
			return n / 2 + 1;
		}
	}
}

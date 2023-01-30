package level2;

public class Solution_숫자변환하기 {
	static int answer;

	public static void main(String[] args) {
		int x = 1;
		int y = 1000000;
		int n = 1;
		System.out.println(solution(x, y, n));

	}

	public static int solution(int x, int y, int n) {
		answer = Integer.MAX_VALUE;
		count(0, x, y, n);
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		return answer;
	}

	public static void count(int cnt, int x, int y, int n) {
		System.out.println(cnt + " " + x + " " + y);
		if (x == y) {
			answer = Math.min(answer, cnt);
			return;
		}

		for (int i = 0; i < 3; i++) {
			int next = calc(i, x, n);
			if (cnt + 1 < answer && next <= y) {
				count(cnt + 1, next, y, n);
			}
		}

	}

	public static int calc(int op, int num, int n) {
		int result = num;
		if (op == 0) {
			result*= 3;
		} else if (op == 1) {
			result *= 2;
		} else {
			result += n;
		}
		return result;
	}

}

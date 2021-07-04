package level1;

public class Solution_하샤드수 {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static boolean solution(int x) {
		boolean answer = true;
		int sum = 0, num = x;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		if (x % sum != 0) answer = false;
		return answer;
	}
}

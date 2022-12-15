package level2;

public class Solution_점찍기 {
	public static void main(String[] args) {
		int k = 1, d = 5;
		System.out.println(solution(k, d));
	}

	public static long solution(int k, int d) {
		long answer = 0;
		int max = (d / k) * k;
		for (int i = 0; i <= max; i += k) {
			int y = (int) Math.sqrt((long) d * d - (long) i * i);
			answer += y / k + 1;
		}
		return answer;
	}
}

package level2;

public class Solution_두원사이의정수쌍 {
	public static void main(String[] args) {
		int r1 = 2, r2 = 3;
		System.out.println(solution(r1, r2));
	}

	static public long solution(int r1, int r2) {
		long answer = 0;
		for (int i = 1; i <= r2; i++) {
			double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2));
			double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2));
			answer += ((long) y2 - (long) Math.ceil(y1) + 1);
		}
		answer *= 4;
		return answer;
	}

}

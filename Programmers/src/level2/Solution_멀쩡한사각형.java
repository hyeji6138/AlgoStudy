package level2;

public class Solution_멀쩡한사각형 {
	public static void main(String[] args) {
		System.out.println(solution(3, 5));
	}

	public static long solution(int w, int h) {
		long answer = 0;
		long sub = (long) Math.min(w, h) * (long) Math.ceil((double) Math.max(w, h) / Math.min(w, h));
		answer = (long) w * (long) h - sub;
		return answer;
	}
}

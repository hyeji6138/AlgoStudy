package level0;

public class Solution_369게임 {
	public static void main(String[] args) {
		int order = 1000000;
		System.out.println(solution(order));
	}

	public static int solution(int order) {
		int answer = 0;
		while (order > 0) {
			int num = order % 10;
			if (num > 0 && num % 3 == 0) {
				answer++;
			}
			order /= 10;
		}
		return answer;
	}

}

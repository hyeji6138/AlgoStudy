package level0;

public class Solution_개미군단 {
	public static void main(String[] args) {
		int hp = 999;
		System.out.println(solution(hp));
	}

	public static int solution(int hp) {
		int answer = 0;
		for (int i = 5; i > 0; i -= 2) {
			answer += hp / i;
			hp %= i;
		}
		return answer;
	}

}

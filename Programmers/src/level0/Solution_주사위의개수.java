package level0;

public class Solution_주사위의개수 {
	public static void main(String[] args) {
		int[] box = { 10, 8, 6 };
		int n = 7;
		System.out.println(solution(box, n));
	}

	public static int solution(int[] box, int n) {
		int answer = 1;
		for (int i = 0; i < box.length; i++) {
			answer *= box[i] / n;
		}
		return answer;
	}

}

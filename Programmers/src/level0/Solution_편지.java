package level0;

public class Solution_편지 {
	public static void main(String[] args) {
		String message = "i love you~";
		System.out.println(solution(message));
	}

	public static int solution(String message) {
		int answer = 0;
		answer = message.length() * 2;
		return answer;
	}

}

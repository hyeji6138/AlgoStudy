package level0;

public class Solution_각도기 {
	public static void main(String[] args) {
		int angle = 70;
		System.out.println(solution(angle));
	}

	public static int solution(int angle) {
		int answer = 0;
		if (angle > 0 && angle < 90) {
			answer = 1;
		} else if (angle == 90) {
			answer = 2;
		} else if (angle > 90 && angle < 180) {
			answer = 3;
		} else {
			answer = 4;
		}
		return answer;
	}

}

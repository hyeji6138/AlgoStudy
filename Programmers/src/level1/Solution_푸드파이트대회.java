package level1;

public class Solution_푸드파이트대회 {
	public static void main(String[] args) {
		int[] food = { 1, 7, 1, 2, 10, 11, 18 };
		System.out.println(solution(food));
	}

	public static String solution(int[] food) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < food.length; i++) {
			if (food[i] % 2 == 0) {
				for (int j = 0; j < food[i]; j++) {
					sb.insert(sb.length()/2, i);
				}
			} else {
				for (int j = 0; j < food[i] - 1; j++) {
					sb.insert(sb.length()/2, i);
				}
			}
		}
		sb.insert(sb.length() / 2, 0);
		answer = sb.toString();
		return answer;
	}

}

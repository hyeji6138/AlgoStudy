package level2;

public class Solution_124나라의숫자 {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	public static String solution(int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		int num = n;

		while ((num - 1) >= 0) {
			if ((num - 1) % 3 == 2) {
				sb.insert(0, 4);
			} else {
				sb.insert(0, (num - 1) % 3 + 1);
			}
			num = (num - 1) / 3;
		}

		answer = sb.toString();
		return answer;
	}
}

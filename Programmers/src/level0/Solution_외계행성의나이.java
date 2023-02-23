package level0;

public class Solution_외계행성의나이 {
	public static void main(String[] args) {
		int age = 23;
		System.out.println(solution(age));
	}

	public static String solution(int age) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		while (age > 0) {
			sb.insert(0, (char) ('a' + age % 10));
			age /= 10;
		}
		answer = sb.toString();
		return answer;
	}
}

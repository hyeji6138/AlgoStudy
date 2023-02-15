package level0;

public class Solution_문자반복출력하기 {
	public static void main(String[] args) {
		String my_string = "hello";
		int n = 3;
		System.out.println(solution(my_string, n));
	}

	public static String solution(String my_string, int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length(); i++) {
			for (int j = 0; j < n; j++) {
				sb.append(my_string.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}

}

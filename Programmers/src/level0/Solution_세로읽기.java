package level0;

public class Solution_세로읽기 {
	public static void main(String[] args) {
		String my_string = "ihrhbakrfpndopljhygc";
		int m = 4, c = 2;
		System.out.println(solution(my_string, m, c));
	}

	public static String solution(String my_string, int m, int c) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length() / m; i++) {
			sb.append(my_string.charAt(m * i + (c - 1)));
		}
		answer = sb.toString();
		return answer;
	}

}

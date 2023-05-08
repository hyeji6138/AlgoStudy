package level0;

public class Solution_문자열의뒤의n글자 {
	public static void main(String[] args) {
		String my_string = "ProgrammerS123";
		int n = 11;
		System.out.println(solution(my_string, n));
	}

	public static String solution(String my_string, int n) {
		String answer = my_string.substring(my_string.length() - n, my_string.length());
		return answer;
	}

}

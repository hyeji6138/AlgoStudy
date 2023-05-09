package level0;

public class Solution_특정한문자를대문자로바꾸기 {
	public static void main(String[] args) {
		String my_string = "Programmers";
		String alp = "p";
		System.out.println(solution(my_string, alp));
	}

	public static String solution(String my_string, String alp) {
		String answer = my_string.replace(alp.charAt(0), alp.toUpperCase().charAt(0));
		return answer;
	}

}

package level0;

public class Solution_소문자로바꾸기 {
	public static void main(String[] args) {
		String myString = "aBcDeFg";
		System.out.println(solution(myString));
	}

	public static String solution(String myString) {
		String answer = "";
		answer = myString.toLowerCase();
		return answer;
	}
}

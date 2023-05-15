package level0;

public class Solution_특정문자열로끝나는가장긴부분문자열찾기 {
	public static void main(String[] args) {
		String myString = "AAAAaaaa";
		String pat = "a";
		System.out.println(solution(myString, pat));
	}

	public static String solution(String myString, String pat) {
		String answer = "";
		int idx = myString.lastIndexOf(pat);
		answer = myString.substring(0, idx + pat.length());
		return answer;
	}

}

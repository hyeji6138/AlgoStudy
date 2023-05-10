package level0;

public class Solution_원하는문자열찾기 {
	public static void main(String[] args) {
		String myString = "AbCdEfG";
		String pat = "aBc";
		System.out.println(solution(myString, pat));
	}

	public static int solution(String myString, String pat) {
		int answer = myString.toLowerCase().indexOf(pat.toLowerCase()) >= 0 ? 1 : 0;
		return answer;
	}

}

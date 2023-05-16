package level0;

public class Solution_문자열이몇번등장하는지세기 {
	public static void main(String[] args) {
		String myString = "aaaa";
		String pat = "aa";
		System.out.println(solution(myString, pat));
	}

	public static int solution(String myString, String pat) {
		int answer = 0;
		String str = myString;
		int idx = str.indexOf(pat);
		while (idx >= 0) {
			answer += 1;
			str = str.substring(idx + 1);
			idx = str.indexOf(pat);
		}
		return answer;
	}

}

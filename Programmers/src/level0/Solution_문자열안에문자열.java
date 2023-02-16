package level0;

public class Solution_문자열안에문자열 {
	public static void main(String[] args) {
		String str1 = "ppprrrogrammers";
		String str2 = "pppp";
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		int answer = 2;
		if (str1.contains(str2)) {
			answer = 1;
		}
		return answer;
	}

}

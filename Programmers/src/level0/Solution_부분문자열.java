package level0;

public class Solution_부분문자열 {
	public static void main(String[] args) {
		String str1 = "tbt", str2 = "tbbttb";
		System.out.println(solution(str1, str2));
	}

	public static int solution(String str1, String str2) {
		int answer = str2.indexOf(str1) >= 0 ? 1 : 0;
		return answer;
	}

}

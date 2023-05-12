package level0;

public class Solution_문자열섞기 {
	public static void main(String[] args) {
		String str1 = "aaaaa", str2 = "bbbbb";
		System.out.println(solution(str1, str2));
	}

	public static String solution(String str1, String str2) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str1.length(); i++) {
			sb.append(str1.charAt(i));
			sb.append(str2.charAt(i));
		}
		answer = sb.toString();
		return answer;
	}

}

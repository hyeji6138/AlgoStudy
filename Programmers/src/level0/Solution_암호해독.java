package level0;

public class Solution_암호해독 {
	public static void main(String[] args) {
		String cipher = "pfqallllabwaoclk";
		int code = 2;
		System.out.println(solution(cipher, code));
	}

	public static String solution(String cipher, int code) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = code; i <= cipher.length(); i += code) {
			sb.append(cipher.charAt(i - 1));
		}
		answer = sb.toString();
		return answer;
	}

}

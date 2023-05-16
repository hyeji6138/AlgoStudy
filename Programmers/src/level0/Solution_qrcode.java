package level0;

public class Solution_qrcode {
	public static void main(String[] args) {
		int q = 3, r = 1;
		String code = "qjnwezgrpirldywt";
		System.out.println(solution(q, r, code));
	}

	public static String solution(int q, int r, String code) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < code.length(); i++) {
			if (i % q == r) {
				sb.append(code.charAt(i));
			}
		}
		answer = sb.toString();
		return answer;
	}

}

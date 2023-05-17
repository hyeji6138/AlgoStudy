package level0;

public class Solution_두수의합2 {
	public static void main(String[] args) {
		String a = "18446744073709551615";
		String b = "287346502836570928366";
		System.out.println(solution(a, b));
	}

	public static String solution(String a, String b) {
		String answer = "";
		int[] num = new int[Math.max(a.length(), b.length()) + 1];
		int add = 0;
		for (int i = 0; i < num.length; i++) {
			int aN = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
			int bN = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
			int sum = aN + bN + add;
			num[num.length - 1 - i] = (sum) % 10;
			add = sum / 10;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = num[0] > 0 ? 0 : 1; i < num.length; i++) {
			sb.append(num[i]);
		}
		answer = sb.toString();
		return answer;
	}

}

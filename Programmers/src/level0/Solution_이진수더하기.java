package level0;

public class Solution_이진수더하기 {
	public static void main(String[] args) {
		String bin1 = "10";
		String bin2 = "11";
		System.out.println(solution(bin1, bin2));
	}

	public static String solution(String bin1, String bin2) {
		String answer = "";
		int b1 = 0, b2 = 0;
		for (int i = 0; i < bin1.length(); i++) {
			if (bin1.charAt(bin1.length() - 1 - i) == '1') {
				b1 += Math.pow(2, i);
			}
		}
		for (int i = 0; i < bin2.length(); i++) {
			if (bin2.charAt(bin2.length() - 1 - i) == '1') {
				b2 += Math.pow(2, i);
			}
		}
		answer = Integer.toBinaryString(b1 + b2);
		return answer;
	}

}

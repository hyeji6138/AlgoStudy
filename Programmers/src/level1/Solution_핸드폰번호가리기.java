package level1;

public class Solution_핸드폰번호가리기 {
	public static void main(String[] args) {
		System.out.println(solution("01033334444"));
	}

	public static String solution(String phone_number) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < phone_number.length() - 4; i++) {
			sb.append("*");
		}
		sb.append(phone_number.substring(phone_number.length() - 4));
		answer = sb.toString();
		return answer;
	}
}

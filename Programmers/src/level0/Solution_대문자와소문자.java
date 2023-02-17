package level0;

public class Solution_대문자와소문자 {
	public static void main(String[] args) {
		String my_string = "cccCCC";
		System.out.println(solution(my_string));
	}

	public static String solution(String my_string) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_string.length(); i++) {
			char x = my_string.charAt(i);
			if (Character.isUpperCase(x)) {
				sb.append(Character.toLowerCase(x));
			} else {
				sb.append(Character.toUpperCase(x));
			}
		}
		answer = sb.toString();
		return answer;
	}

}

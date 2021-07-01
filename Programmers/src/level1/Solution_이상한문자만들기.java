package level1;

public class Solution_이상한문자만들기 {
	public static void main(String[] args) {
		System.out.println(solution("try hello world"));
	}

	public static String solution(String s) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		String[] strings = s.split("");
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (strings[i].equals(" ")) {
				sb.append(" ");
				idx = 0;
			} else {
				if (idx % 2 == 0) {
					sb.append(strings[i].toUpperCase());
				} else {
					sb.append(strings[i].toLowerCase());
				}
				idx++;
			}
		}
		answer = sb.toString();
		return answer;
	}
}

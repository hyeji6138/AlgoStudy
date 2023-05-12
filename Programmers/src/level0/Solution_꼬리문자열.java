package level0;

public class Solution_꼬리문자열 {
	public static void main(String[] args) {
		String[] str_list = { "abc", "bbc", "cbc" };
		String ex = "c";
		System.out.println(solution(str_list, ex));
	}

	public static String solution(String[] str_list, String ex) {
		String answer = "";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str_list.length; i++) {
			if (str_list[i].indexOf(ex) >= 0) {
				continue;
			}
			sb.append(str_list[i]);
		}
		answer = sb.toString();
		return answer;
	}

}

package level0;

import java.util.HashSet;

public class Solution_중복된문자제거 {

	public static void main(String[] args) {
		String my_string = "We are the world";
		System.out.println(solution(my_string));
	}

	public static String solution(String my_string) {
		String answer = "";
		HashSet<Character> hash = new HashSet<>();
		char[] my_char = my_string.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < my_char.length; i++) {
			if (!hash.contains(my_char[i])) {
				sb.append(my_char[i]);
				hash.add(my_char[i]);
			}
		}
		answer = sb.toString();
		return answer;
	}
}

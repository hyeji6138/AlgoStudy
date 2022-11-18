package level2;

public class Solution_JadenCase문자열만들기 {
	public static void main(String[] args) {
		String s = "3people unFollowed me p  ";
		System.out.println(solution(s));

	}

	public static String solution(String s) {
		String answer = "";
		String[] words = s.split(" ", -1);
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() >= 1) {
				answer += words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
			}
			if (i < words.length - 1) {
				answer += " ";
			}
		}
		return answer + "*";
	}

}

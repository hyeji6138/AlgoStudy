package level0;

public class Solution_문자열뒤집기2 {
	public static void main(String[] args) {
		String my_string = "Progra21Sremm3";
		int s = 6, e = 12;
		System.out.println(solution(my_string, s, e));
	}

	public static String solution(String my_string, int s, int e) {
		String answer = "";
		String[] str = my_string.split("");
		for (int i = 0; i < (e - s + 1) / 2; i++) {
			String temp = str[s + i];
			str[s + i] = str[e - i];
			str[e - i] = temp;
		}
		answer = String.join("", str);
		return answer;
	}

}

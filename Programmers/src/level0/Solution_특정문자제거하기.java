package level0;

public class Solution_특정문자제거하기 {
	public static void main(String[] args) {
		String my_string = "abcdef";
		String letter = "f";
		System.out.println(solution(my_string, letter));
	}

	public static String solution(String my_string, String letter) {
		String answer = "";
		answer = my_string.replace(letter, "");
		return answer;
	}

}

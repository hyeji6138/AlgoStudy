package level0;

public class Solution_모음제거 {
	public static void main(String[] args) {
		String my_string = "bus";
		System.out.println(solution(my_string));
	}

	public static String solution(String my_string) {
		String answer = my_string;
		String[] vowel = { "a", "e", "i", "o", "u" };
		for (int i = 0; i < vowel.length; i++) {
			answer = answer.replace(vowel[i], "");
		}
		return answer;
	}

}

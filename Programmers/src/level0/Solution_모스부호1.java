package level0;

import java.util.HashMap;

public class Solution_모스부호1 {
	static HashMap<String, Character> hash = new HashMap<String, Character>() {
		{
			put(".-", 'a');
			put("-...", 'b');
			put("-.-.", 'c');
			put("-..", 'd');
			put(".", 'e');
			put("..-.", 'f');
			put("--.", 'g');
			put("....", 'h');
			put("..", 'i');
			put(".---", 'j');
			put("-.-", 'k');
			put(".-..", 'l');
			put("--", 'm');
			put("-.", 'n');
			put("---", 'o');
			put(".--.", 'p');
			put("--.-", 'q');
			put(".-.", 'r');
			put("...", 's');
			put("-", 't');
			put("..-", 'u');
			put("...-", 'v');
			put(".--", 'w');
			put("-..-", 'x');
			put("-.--", 'y');
			put("--..", 'z');
		}
	};

	public static void main(String[] args) {
		String letter = ".... . .-.. .-.. ---";
		System.out.println(solution(letter));
	}

	public static String solution(String letter) {
		String answer = "";
		String[] letters = letter.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < letters.length; i++) {
			sb.append(hash.get(letters[i]));
		}
		answer = sb.toString();
		return answer;
	}
}

package level1;

public class Solution_숫자문자열과영단어 {
	public static void main(String[] args) {
		String s = "23four5six7";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		int answer = 0;
		String[] eng = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		for (int i = 0; i <= 9; i++) {
			s = s.replaceAll(eng[i], Integer.toString(i));
		}
		answer = Integer.parseInt(s);
		return answer;
	}
}

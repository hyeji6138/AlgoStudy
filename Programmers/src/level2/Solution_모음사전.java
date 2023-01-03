package level2;

public class Solution_모음사전 {
	static char[] alpha = { 'A', 'E', 'I', 'O', 'U' };
	static int answer;
	static boolean find;

	public static void main(String[] args) {
		String word = "EIO";
		System.out.println(solution(word));
	}

	public static int solution(String word) {
		answer = 0;
		find = false;
		search("", word);
		return answer;
	}

	public static void search(String s, String target) {
		if (s.equals(target)) {
			find = true;
			return;
		} else if (s.length() == 5) {
			return;
		}

		for (int i = 0; i < 5; i++) {
			if (!find) {
				StringBuffer sb = new StringBuffer(s);
				sb.append(alpha[i]);
				answer++;
				search(sb.toString(), target);
			}
		}
	}

}

package level0;

public class Solution_문자열을정수로변환하기 {
	public static void main(String[] args) {
		String n_str = "10";
		System.out.println(solution(n_str));
	}

	public static int solution(String n_str) {
		int answer = 0;
		answer = Integer.parseInt(n_str);
		return answer;
	}

}

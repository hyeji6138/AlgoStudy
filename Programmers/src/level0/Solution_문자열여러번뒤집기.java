package level0;

public class Solution_문자열여러번뒤집기 {
	public static void main(String[] args) {
		String my_string = "rermgorpsam";
		int[][] queries = { { 2, 3 }, { 0, 7 }, { 5, 9 }, { 6, 10 } };
		System.out.println(solution(my_string, queries));
	}

	public static String solution(String my_string, int[][] queries) {
		String answer = "";
		String[] spl = my_string.split("");
		for (int i = 0; i < queries.length; i++) {
			for (int j = 0; j < (queries[i][1] - queries[i][0] + 1) / 2; j++) {
				String temp = spl[queries[i][0] + j];
				spl[queries[i][0] + j] = spl[queries[i][1] - j];
				spl[queries[i][1] - j] = temp;
			}
		}
		answer = String.join("", spl);
		return answer;
	}

}

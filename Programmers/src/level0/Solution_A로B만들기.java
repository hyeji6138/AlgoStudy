package level0;

public class Solution_A로B만들기 {
	public static void main(String[] args) {
		String before = "olleh";
		String after = "hello";
		System.out.println(solution(before, after));
	}

	public static int solution(String before, String after) {
		int answer = 1;
		int[][] alpha = new int[26][2];
		for (int i = 0; i < before.length(); i++) {
			alpha[before.charAt(i) - 'a'][0]++;
			alpha[after.charAt(i) - 'a'][1]++;
		}
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i][0] != alpha[i][1]) {
				answer = 0;
				break;
			}
		}

		return answer;
	}

}

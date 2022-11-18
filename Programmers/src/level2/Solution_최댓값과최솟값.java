package level2;

public class Solution_최댓값과최솟값 {
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";
		String[] number = s.split(" ");
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < number.length; i++) {
			int n = Integer.parseInt(number[i]);
			if (min > n) {
				min = n;
			}
			if (max < n) {
				max = n;
			}
		}
		answer = min + " " + max;
		return answer;
	}

}

package level0;

import java.util.Arrays;

public class Solution_분수의덧셈 {
	public static void main(String[] args) {
		int numer1 = 1, denom1 = 2;
		int numer2 = 3, denom2 = 4;
		System.out.println(Arrays.toString(solution(numer1, denom1, numer2, denom2)));
	}

	public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
		int[] answer = new int[2];
		int numer = numer1 * denom2 + numer2 * denom1;
		int denom = denom1 * denom2;
		int gcf = 1;
		for (int i = 2; i <= Math.min(numer, denom); i++) {
			if (numer % i == 0 && denom % i == 0) {
				gcf = i;
			}
		}
		answer[0] = numer / gcf;
		answer[1] = denom / gcf;
		return answer;
	}

}

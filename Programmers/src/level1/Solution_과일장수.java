package level1;

import java.util.Arrays;

public class Solution_과일장수 {
	public static void main(String[] args) {
		int k = 4;
		int m = 4;
		int[] score = { 1, 1, 2, 3, 4, 2, 3, 4 };
		System.out.println(solution(k, m, score));
	}

	public static int solution(int k, int m, int[] score) {
		int answer = 0;
		Arrays.sort(score);
		int idx = score.length - m;
		while (idx >= 0) {
			System.out.println(score[idx] + " * " + m);
			answer += score[idx] * m;
			idx -= m;
		}
		return answer;
	}

}

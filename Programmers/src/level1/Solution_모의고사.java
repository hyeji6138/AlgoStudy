package level1;

import java.util.Arrays;

public class Solution_모의고사 {
	public static void main(String[] args) {
		int[] answers = { 1,3,2,4,2 };
		System.out.println(Arrays.toString(solution(answers)));
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};
		int[][] std = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[] idx = new int[3], score = new int[3];
		int maxScore = 0;

		for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (std[j][idx[j]] == answers[i]) {
					score[j]++;
					maxScore = Math.max(maxScore, score[j]);
				}
				idx[j] = (idx[j] + 1) % std[j].length;
			}
		}
		int cnt = 0;
		for(int i=0;i<3;i++) {
			if(maxScore == score[i]) {
				cnt++;
			}
		}
		answer = new int[cnt];
		int j = 0;
		for(int i=0;i<3;i++) {
			if(maxScore == score[i]) {
				answer[j++] = i+1;
			}
		}
		return answer;
	}
}

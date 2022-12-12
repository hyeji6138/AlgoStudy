package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_명예의전당 {
	public static void main(String[] args) {
		int k = 4;
		int[] score = { 0, 300, 40, 300, 20, 70, 150, 50, 500, 1000 };
		System.out.println(Arrays.toString(solution(k, score)));
	}

	public static int[] solution(int k, int[] score) {
		int[] answer = new int[score.length];
		List<Integer> honor = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < score.length; i++) {
			if (honor.size() < k) {
				honor.add(score[i]);
				if (min > score[i]) {
					min = score[i];
				}
			} else {
				if (min < score[i]) {
					int idx = honor.indexOf(min);
					honor.remove(idx);
					honor.add(score[i]);
					min = Integer.MAX_VALUE;
					for (int j = 0; j < honor.size(); j++) {
						if (min > honor.get(j)) {
							min = honor.get(j);
						}
					}
				}
			}
			answer[i] = min;
		}
		return answer;
	}

}

package level1;

import java.util.HashMap;

public class Solution_성격유형검사하기 {
	public static void main(String[] args) {
		String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
		int[] choices = { 5, 3, 2, 7, 5 };
		System.out.println(solution(survey, choices));

	}

	public static String solution(String[] survey, int[] choices) {
		StringBuffer answer = new StringBuffer();
		char[] type = { 'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N' };
		HashMap<Character, Integer> types = new HashMap<>();
		for (int i = 0; i < type.length; i++) {
			types.put(type[i], i);
		}
		int[] score = new int[8];
		for (int i = 0; i < survey.length; i++) {
			char[] surveyType = survey[i].toCharArray();
			score[types.get(surveyType[choices[i] / 4])] += Math.abs(choices[i] - 4);
		}
		for (int i = 0; i < type.length; i += 2) {
			if (score[i] >= score[i + 1]) {
				answer.append(type[i]);
			} else {
				answer.append(type[i + 1]);
			}
		}

		return answer.toString();
	}

}

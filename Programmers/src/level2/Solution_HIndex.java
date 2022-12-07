package level2;

import java.util.Arrays;

public class Solution_HIndex {
	public static void main(String[] args) {
		int[] citations = { 5, 5, 5, 5, 6, 6, 6, 6, 6, 6 };
		System.out.println(solution(citations));
	}

	public static int solution(int[] citations) {
		int answer = 0;
		Arrays.sort(citations);
		for (int i = 0; i < citations.length; i++) {
			System.out.println("h: " + (citations.length - i) + " ");
			if (citations.length - i <= citations[i]) {
				answer = citations.length - i;
				break;
			}
		}
		return answer;
	}
}

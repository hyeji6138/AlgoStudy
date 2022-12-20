package level2;

import java.util.HashSet;

public class Solution_연속부분수열합의개수 {
	public static void main(String[] args) {
		int[] elements = { 7, 9, 1, 1, 4 };
		System.out.println(solution(elements));
	}

	public static int solution(int[] elements) {
		int answer = 0;
		int total = 0;
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int i = 0; i < elements.length; i++) {
			total += elements[i];
		}
		hash.add(total);
		for (int i = 1; i <= elements.length / 2; i++) {
			int sum = 0;
			for (int j = 0; j < i; j++) {
				sum += elements[j];
			}
			if (!hash.contains(sum)) {
				hash.add(sum);
			}
			if (!hash.contains(total - sum)) {
				hash.add(total - sum);
			}
			for (int j = 0; j < elements.length; j++) {
				sum = sum - elements[j] + elements[(j + i) % elements.length];
				if (!hash.contains(sum)) {
					hash.add(sum);
				}
				if (!hash.contains(total - sum)) {
					hash.add(total - sum);
				}
			}
		}
		answer = hash.size();
		return answer;
	}

}

package level2;

import java.util.Arrays;

public class Solution_구명보트 {
	public static void main(String[] args) {
		int[] people = { 10, 30, 20, 20, 30, 40 };
		int limit = 40;
		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		Arrays.sort(people);
		int left = 0, right = people.length - 1;
		while (left <= right) {
			System.out.println(left + " " + right);
			int sum = people[right];
			while (left < right) {
				if (sum + people[left] <= limit) {
					sum += people[left];
					left++;
				} else {
					break;
				}
			}
			answer++;
			right--;
		}
		return answer;
	}

}

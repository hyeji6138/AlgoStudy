package level0;

import java.util.HashMap;

public class Solution_전국대회선발고사 {
	public static void main(String[] args) {
		int[] rank = { 3, 7, 2, 5, 4, 6, 1 };
		boolean[] attendance = { false, true, true, true, true, false, false };
		System.out.println(solution(rank, attendance));
	}

	public static int solution(int[] rank, boolean[] attendance) {
		int answer = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < rank.length; i++) {
			hashMap.put(rank[i], i);
		}
		int score = 10000;
		for (int i = 1; i <= rank.length && score > 0; i++) {
			int std = hashMap.get(i);
			if (attendance[std]) {
				answer += score * std;
				score /= 100;
			}
		}
		return answer;
	}

}

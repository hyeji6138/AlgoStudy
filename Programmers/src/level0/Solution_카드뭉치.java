package level0;

import java.util.HashMap;

public class Solution_카드뭉치 {
	public static void main(String[] args) {
		String[] cards1 = { "i", "water", "drink" };
		String[] cards2 = { "want", "to" };
		String[] goal = { "i", "want", "to", "drink", "water" };
		System.out.println(solution(cards1, cards2, goal));
	}

	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		String answer = "Yes";
		boolean[] card1 = new boolean[cards1.length];
		boolean[] card2 = new boolean[cards2.length];
		HashMap<String, int[]> hash = new HashMap<String, int[]>();
		for (int i = 0; i < cards1.length; i++) {
			hash.put(cards1[i], new int[] { 1, i });
		}
		for (int i = 0; i < cards2.length; i++) {
			hash.put(cards2[i], new int[] { 2, i });
		}

		for (int i = 0; i < goal.length; i++) {
			if (!hash.containsKey(goal[i])) {
				answer = "No";
				break;
			} else {
				int[] now = hash.get(goal[i]);
				if (now[0] == 1) {
					if (now[1] > 0) {
						if (card1[now[1] - 1]) {
							card1[now[1]] = true;
						} else {
							answer = "No";
							break;
						}
					} else {
						card1[now[1]] = true;
					}
				} else {
					if (now[1] > 0) {
						if (card2[now[1] - 1]) {
							card2[now[1]] = true;
						} else {
							answer = "No";
							break;
						}
					} else {
						card2[now[1]] = true;
					}
				}
			}
		}

		return answer;
	}

}

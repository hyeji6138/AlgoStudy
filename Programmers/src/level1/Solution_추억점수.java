package level1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_추억점수 {
	public static void main(String[] args) {
		String[] name = { "may", "kein", "kain", "radi" };
		int[] yearning = { 5, 10, 1, 3 };
		String[][] photo = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" },
				{ "kon", "kain", "may", "coni" } };
		System.out.println(Arrays.toString(solution(name, yearning, photo)));
	}

	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (int i = 0; i < name.length; i++) {
			hashMap.put(name[i], yearning[i]);
		}
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length; j++) {
				if (hashMap.containsKey(photo[i][j])) {
					answer[i] += hashMap.get(photo[i][j]);
				}
			}
		}
		return answer;
	}

}

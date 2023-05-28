package level1;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_달리기경주 {
	public static void main(String[] args) {
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };
		System.out.println(Arrays.toString(solution(players, callings)));
	}

	public static String[] solution(String[] players, String[] callings) {
		String[] answer = new String[players.length];
		HashMap<String, Integer> runner = new HashMap<>();
		for (int i = 0; i < players.length; i++) {
			runner.put(players[i], i);
			answer[i] = players[i];
		}
		for (int i = 0; i < callings.length; i++) {
			int r = runner.get(callings[i]);
			String p = answer[r - 1];
			runner.replace(callings[i], r - 1);
			runner.replace(p, r);
			answer[r - 1] = callings[i];
			answer[r] = p;
		}
		return answer;
	}

}

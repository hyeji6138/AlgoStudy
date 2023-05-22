package level1;

import java.util.Arrays;

public class Solution_대충만든자판 {
	public static void main(String[] args) {
		String[] keymap = { "ABACD", "BCEFD" };
		String[] targets = { "ABCD", "AABB" };
		System.out.println(Arrays.toString(solution(keymap, targets)));
	}

	public static int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];
		int[] keyboard = new int[26];
		for (int i = 0; i < keyboard.length; i++) {
			keyboard[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < keymap.length; i++) {
			for (int j = 0; j < keymap[i].length(); j++) {
				char x = keymap[i].charAt(j);
				if (j + 1 < keyboard[x - 'A']) {
					keyboard[x - 'A'] = j + 1;
				}
			}
		}
		for (int i = 0; i < targets.length; i++) {
			int cnt = 0;
			for (int j = 0; j < targets[i].length(); j++) {
				char x = targets[i].charAt(j);
				if (keyboard[x - 'A'] == Integer.MAX_VALUE) {
					cnt = -1;
					break;
				}
				cnt += keyboard[x - 'A'];
			}
			answer[i] = cnt;
		}
		return answer;
	}

}

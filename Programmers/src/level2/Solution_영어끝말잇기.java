package level2;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_영어끝말잇기 {
	public static void main(String[] args) {
		int n = 2;
		String[] words = { "hello", "one", "even", "never", "now", "world", "draw" };
		System.out.println(Arrays.toString(solution(n, words)));
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		int failIdx = 0, failTurn = 1;
		HashSet<String> hash = new HashSet<>();
		boolean fail = false;
		char std = words[0].charAt(words[0].length() - 1);
		hash.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			if (std != words[i].charAt(0) || hash.contains(words[i])) {
				fail = true;
				failIdx = i % n + 1;
				break;
			} else {
				std = words[i].charAt(words[i].length() - 1);
				hash.add(words[i]);
			}

			if ((i + 1) % n == 0) {
				failTurn++;
			}
		}
		if (fail) {
			answer[0] = failIdx;
			answer[1] = failTurn;
		}
		return answer;
	}

}

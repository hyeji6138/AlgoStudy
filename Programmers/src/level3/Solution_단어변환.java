package level3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_단어변환 {
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(solution(begin, target, words));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = 0;
		Queue<String> queue = new LinkedList<>();
		boolean[] visit = new boolean[words.length];
		boolean pos = false;
		queue.add(begin);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				String word = queue.poll();
				if (word.equals(target)) {
					pos = true;
					break;
				}
				for (int i = 0; i < words.length; i++) {
					if (!visit[i] && check(word, words[i])) {
						visit[i] = true;
						queue.add(words[i]);
					}
				}
			}
			if (pos) {
				break;
			}
			answer++;
		}
		if (!pos) {
			answer = 0;
		}

		return answer;
	}

	public static boolean check(String s1, String s2) {
		int cnt = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				cnt++;
			}
		}
		if (cnt > 1) {
			return false;
		}
		return true;
	}

}

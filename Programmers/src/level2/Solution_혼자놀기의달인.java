package level2;

import java.util.Arrays;

public class Solution_혼자놀기의달인 {
	public static void main(String[] args) {
		int[] cards = { 8, 6, 3, 7, 2, 5, 1, 4 };
		System.out.println(solution(cards));
	}

	public static int solution(int[] cards) {
		int answer = 0;
		int[] union = new int[cards.length];
		boolean[] visit = new boolean[cards.length];
		int uid = 0;
		for (int i = 0; i < cards.length; i++) {
			if (!visit[i]) {
				union[i] = uid;
				visit[i] = true;
				int next = cards[i] - 1;
				while (!visit[next]) {
					union[next] = uid;
					visit[next] = true;
					next = cards[next] - 1;
				}
				uid++;
			}
		}
		if (uid < 2) {
			answer = 0;
		} else {
			int[] cnt = new int[uid];
			for (int i = 0; i < union.length; i++) {
				cnt[union[i]]++;
			}
			Arrays.sort(cnt);
			answer = cnt[uid - 1] * cnt[uid - 2];
		}
		return answer;
	}

}

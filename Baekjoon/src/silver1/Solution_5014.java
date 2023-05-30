package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] cnt = new int[F + 1];
		for (int i = 1; i < cnt.length; i++) {
			cnt[i] = Integer.MAX_VALUE;
		}
		cnt[S] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		while (!q.isEmpty()) {
			int now = q.poll();
			if (now == G) {
				break;
			}

			if (now + U <= F && now + U > 0 && cnt[now] + 1 < cnt[now + U]) {
				cnt[now + U] = cnt[now] + 1;
				q.add(now + U);
			}

			if (now - D <= F && now - D > 0 && cnt[now] + 1 < cnt[now - D]) {
				cnt[now - D] = cnt[now] + 1;
				q.add(now - D);
			}
		}

		if (cnt[G] == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(cnt[G]);
		}

	}
}

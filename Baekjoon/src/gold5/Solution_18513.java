package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_18513 { // 샘터
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long answer = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		HashSet<Integer> select = new HashSet<Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int sam = Integer.parseInt(st.nextToken());
			q.add(sam);
			select.add(sam);
		}
		// ==============입력 끝=====================
		int k = K;
		int dist = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int now = q.poll();
				if (!select.contains(now - 1)) {
					select.add(now - 1);
					q.add(now - 1);
					k--;
					answer += dist;
					if (k == 0) break;
				}
				if (!select.contains(now + 1)) {
					select.add(now + 1);
					q.add(now + 1);
					k--;
					answer += dist;
					if (k == 0) break;
				}
			}
			dist++;
			if (k == 0) break;
		}
		System.out.println(answer);
	}
}

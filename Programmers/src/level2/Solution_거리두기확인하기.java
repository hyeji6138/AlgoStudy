package level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_거리두기확인하기 {
	public static void main(String[] args) {
		String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };
		System.out.println(Arrays.toString(solution(places)));
	}

	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 };
		for (int p = 0; p < 5; p++) {
			boolean suc = true;
			for (int i = 0; i < 5 && suc; i++) {
				for (int j = 0; j < 5 && suc; j++) {
					if (places[p][i].charAt(j) == 'P') { // 응시자
						Queue<int[]> q = new LinkedList<int[]>();
						boolean visit[][] = new boolean[5][5];
						q.add(new int[] { i, j });
						visit[i][j] = true;
						int dist = 0;
						while (!q.isEmpty() && suc && dist < 2) {
							int size = q.size();
							for (int s = 0; s < size; s++) {
								int[] now = q.poll();

								for (int d = 0; d < 4 && suc; d++) {
									int ni = now[0] + di[d];
									int nj = now[1] + dj[d];

									if (ni >= 0 && ni < 5 && nj >= 0 && nj < 5 && !visit[ni][nj]) {
										if (places[p][ni].charAt(nj) == 'P') { // 실패
											suc = false;
										} else if (places[p][ni].charAt(nj) == 'O') {
											q.add(new int[] { ni, nj });
											visit[ni][nj] = true;
										}
									}
								}
							}
							dist++;
						}
					}
				}
			}
			answer[p] = suc ? 1 : 0;
		}

		return answer;
	}
}

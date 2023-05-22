package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_무인도여행 {
	static int[] di = { -1, 1, 0, 0 }, dj = { 0, 0, -1, 1 }; // 상하좌우

	public static void main(String[] args) {
		String[] maps = { "X591X", "X1X5X", "X231X", "1XXX1" };
		System.out.println(Arrays.toString(solution(maps)));
	}

	public static int[] solution(String[] maps) {
		int[] answer = { -1 };
		List<Integer> list = new ArrayList<>();
		boolean[][] visit = new boolean[maps.length][maps[0].length()];
		int N = maps.length, M = maps[0].length();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (maps[i].charAt(j) != 'X' && !visit[i][j]) {
					visit[i][j] = true;
					Queue<int[]> q = new LinkedList<>();
					int sum = maps[i].charAt(j) - '0';
					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] p = q.poll();
						for (int d = 0; d < di.length; d++) {
							int ni = p[0] + di[d];
							int nj = p[1] + dj[d];
							if (ni >= 0 && ni < N && nj >= 0 && nj < M && maps[ni].charAt(nj) != 'X'
									&& !visit[ni][nj]) {
								q.add(new int[] { ni, nj });
								visit[ni][nj] = true;
								sum += maps[ni].charAt(nj) - '0';
							}
						}
					}
					list.add(sum);
				}
			}
		}
		if (list.size() > 0) {
			answer = new int[list.size()];
			Collections.sort(list);
			for (int i = 0; i < answer.length; i++) {
				answer[i] = list.get(i);
			}
		}
		return answer;
	}

}

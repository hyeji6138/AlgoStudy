package level3;

import java.util.ArrayList;
import java.util.List;

public class Solution_자물쇠와열쇠 {
	static int N, M;

	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		System.out.println(solution(key, lock));

	}

	static public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		N = lock.length;
		M = key.length;
		List<int[]> keyList = new ArrayList<int[]>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				if (key[i][j] == 1) {
					keyList.add(new int[] { i, j });
				}
			}
		}
		int keySize = keyList.size();
		boolean lockCheck = true; //홈이 다 막혀있는 경우
		for (int i = 0; i < N && !answer; i++) {
			for (int j = 0; j < N && !answer; j++) {
				if (lock[i][j] == 1) {
					continue;
				} else {
					lockCheck = false;
					for (int s = 0; s < keySize && !answer; s++) {
						int[] standard = { keyList.get(s)[0] * -1, keyList.get(s)[1] * -1 };
						int[][] keys = new int[keySize][2];
						for (int k = 0; k < keySize; k++) {
							keys[k][0] = keyList.get(k)[0] + standard[0];
							keys[k][1] = keyList.get(k)[1] + standard[1];
						}

						int d = 0;
						do {
							answer = unlocked(lock, i, j, keys);
							for (int k = 0; k < keySize; k++) { //키 회전
								int temp = keys[k][0];
								keys[k][0] = keys[k][1];
								keys[k][1] = temp * -1;
							}
							d++;
						} while (d < 4 && !answer);
					}
				}
			}
		}
		if (lockCheck) {
			answer = true;
		}
		return answer;
	}

	static public boolean unlocked(int[][] lock, int x, int y, int[][] keys) {
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = lock[i][j];
			}
		}

		for (int k = 0; k < keys.length; k++) {
			int ki = keys[k][0] + x;
			int kj = keys[k][1] + y;

			if (ki < 0 || ki >= N || kj < 0 || kj >= N) {
				continue;
			}
			map[ki][kj] += 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

}

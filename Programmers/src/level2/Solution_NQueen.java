package level2;

public class Solution_NQueen {
	static int[] select;
	static boolean[] visit;
	static int answer;

	public static void main(String[] args) {
		int n = 4;
		System.out.println(solution(n));
	}

	static public int solution(int n) {
		answer = 0;
		select = new int[n];
		visit = new boolean[n];
		go(0, n);
		return answer;
	}

	static public void go(int cnt, int n) {
		if (cnt == n) {
			answer += 1;
			return;
		}

		for (int i = 0; i < n; i++) {
//			select[cnt] = i;
//			if (check2(cnt)) {
//				go(cnt + 1, n);
//			}
			if (!visit[i]) {
				if (check(cnt, i, n)) {
					select[cnt] = i;
					visit[i] = true;
					go(cnt + 1, n);
					visit[i] = false;
				}
			}
		}
	}

//	static public boolean check2(int cnt) {
//		for (int i = 0; i < cnt; i++) {
//			if (select[cnt] == select[i])
//				return false;
//			if (Math.abs(cnt - i) == Math.abs(select[cnt] - select[i]))
//				return false;
//		}
//		return true;
//	}

	static public boolean check(int cnt, int loc, int n) { // 대각선 확인
		for (int j = 1; cnt - j >= 0 && loc - j >= 0; j++) {
			if (select[cnt - j] == loc - j) {
				return false;
			}
		}
		for (int j = 1; cnt - j >= 0 && loc + j < n; j++) {
			if (select[cnt - j] == loc + j) {
				return false;
			}
		}
		return true;
	}

}

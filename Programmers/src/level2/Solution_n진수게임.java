package level2;

public class Solution_n진수게임 {
	public static void main(String[] args) {
		int n = 16;
		int t = 16;
		int m = 2;
		int p = 1;
		System.out.println(solution(n, t, m, p));
	}

	public static String solution(int n, int t, int m, int p) {
		String answer = "";
		int cnt = 0, num = 0, turn = 1;
		StringBuffer sb = new StringBuffer();
		while (cnt < t) {
			int x = num;
			StringBuffer temp = new StringBuffer();
			if (x == 0) {
				temp.insert(0, 0);
			} else {
				while (x > 0) {
					if (x % n >= 10 && x % n <= 15) {
						temp.insert(0, (char) ('A' + x % n - 10));
					} else {
						temp.insert(0, x % n);
					}
					x = x / n;
				}
			}
			for (int i = 0; i < temp.length(); i++) {
				if (cnt >= t) break;
//				System.out.println(p + " " + turn);
				if (p % m == turn) {
					sb.append(temp.charAt(i));
					cnt++;
				}
				turn = (turn + 1) % m;
			}
			num++;
		}
		answer = sb.toString();
		return answer;
	}

}

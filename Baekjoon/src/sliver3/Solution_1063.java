package sliver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1063 {
	static int N;
	static int[] stone, king;
	static int[] di = { 1, 1, 0, -1, -1, -1, 0, 1 }, dj = { 0, 1, 1, 1, 0, -1, -1, -1 }; // 시계방향

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		king = convertAlpha(st.nextToken());
		stone = convertAlpha(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int n = 0; n < N; n++) {
			String step = br.readLine();
			switch (step) {
			case "T":
				go(0);
				break;
			case "RT":
				go(1);
				break;
			case "R":
				go(2);
				break;
			case "RB":
				go(3);
				break;
			case "B":
				go(4);
				break;
			case "LB":
				go(5);
				break;
			case "L":
				go(6);
				break;
			case "LT":
				go(7);
				break;
			}
		}

		System.out.println(convertPoint(king) + "\n" + convertPoint(stone));

	}

	public static int[] convertAlpha(String x) {
		char[] point = x.toCharArray();
		return new int[] { (int) (point[1] - '1'), (int) (point[0] - 'A') };
	}

	public static String convertPoint(int[] point) {
		StringBuffer sb = new StringBuffer();
		sb.append((char) ('A' + point[1]));
		sb.append(1 + point[0]);
		return sb.toString();
	}

	public static boolean check(int i, int j) {
		return i >= 0 && i < 8 && j >= 0 && j < 8;
	}

	public static void go(int d) {
		int k_ni = king[0] + di[d];
		int k_nj = king[1] + dj[d];
		if(k_ni == stone[0] && k_nj == stone[1]) {
			int s_ni = stone[0] + di[d];
			int s_nj = stone[1] + dj[d];
			if(check(k_ni, k_nj) && check(s_ni, s_nj)) {
				king[0] = k_ni;
				king[1] = k_nj;
				stone[0] = s_ni;
				stone[1] = s_nj;
			}
		}else {
			if(check(k_ni, k_nj)) {
				king[0] = k_ni;
				king[1] = k_nj;
			}
		}
	}

}

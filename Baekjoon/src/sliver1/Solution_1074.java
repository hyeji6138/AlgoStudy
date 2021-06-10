package sliver1;

import java.util.Scanner;

public class Solution_1074 {
	static int N, r, c;

	public static void main(String[] args) { // Z
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		int size = (int) Math.pow(2, N);
		int cnt = 0;
		while (size > 0) {
			int loc = location(r / size, c / size);
			cnt += Math.pow(size, 2) * loc;
			size = size / 2;
		}
		System.out.println(cnt);
		sc.close();
	}

	public static int location(int r, int c) {
		if (r % 2 == 0 && c % 2 == 0) {
			return 0;
		} else if (r % 2 == 0 && c % 2 == 1) {
			return 1;
		} else if (r % 2 == 1 && c % 2 == 0) {
			return 2;
		} else {
			return 3;
		}
	}

}

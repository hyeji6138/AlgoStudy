package gold3;

import java.util.Scanner;

public class Solution_1030 { // 프렉탈 평면
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[7];
		for (int i = 0; i < 7; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		// ==============입력 끝=====================
		StringBuffer sb = new StringBuffer();
		for (int i = input[3]; i <= input[4]; i++) {
			for (int j = input[5]; j <= input[6]; j++) {
				sb.append(getColor(i, j));
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int getColor(int i, int j) {
		int n = (int) Math.pow(input[1], input[0]);
		int ni = i, nj = j;
		while ((n /= input[1]) != 0) {
			if (isMiddle(ni / n, nj / n)) return 1;

			ni %= n;
			nj %= n;
		}
		return 0;
	}

	public static boolean isMiddle(int i, int j) {
		int s = (input[1] - input[2]) / 2;
		int e = (input[1] + input[2]) / 2;
		if ((s <= i && i < e) && (s <= j && j < e)) return true;
		return false;

	}

}

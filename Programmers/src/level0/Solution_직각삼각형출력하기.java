package level0;

import java.util.Scanner;

public class Solution_직각삼각형출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		sc.close();
		System.out.println(sb.toString());
	}
}

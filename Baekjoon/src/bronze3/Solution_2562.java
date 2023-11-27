package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2562 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int max = Integer.MIN_VALUE;
		int idx = -1;
		for (int i = 1; i <= 9; i++) {
			int n = Integer.parseInt(br.readLine());
			if (max < n) {
				max = n;
				idx = i;
			}
		}
		System.out.println(max);
		System.out.println(idx);
	}

}

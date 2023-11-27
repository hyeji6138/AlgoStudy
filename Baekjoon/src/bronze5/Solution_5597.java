package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_5597 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] std = new boolean[31];
		for (int i = 0; i < 28; i++) {
			int n = Integer.parseInt(br.readLine());
			std[n] = true;
		}
		for (int i = 1; i <= 30; i++) {
			if (!std[i]) {
				System.out.println(i);
			}
		}
	}

}

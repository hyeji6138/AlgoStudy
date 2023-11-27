package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] array = new int[42];
		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			array[n % 42] += 1;
		}
		int count = 0;
		for (int i = 0; i < 42; i++) {
			if (array[i] > 0) {
				count += 1;
			}
		}
		System.out.println(count);
	}

}

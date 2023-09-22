package bronze5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_14681 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		if (a > 0) {
			if (b > 0) {
				System.out.println(1);
			} else {
				System.out.println(4);
			}
		} else {
			if (b > 0) {
				System.out.println(2);
			} else {
				System.out.println(3);
			}
		}
	}

}

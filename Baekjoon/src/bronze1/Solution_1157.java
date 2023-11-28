package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alpha[Character.toLowerCase(s.charAt(i)) - 'a'] += 1;
		}
		int max = 0;
		int idx = 0;
		for (int i = 0; i < 26; i++) {
			if (max < alpha[i]) {
				max = alpha[i];
				idx = i;
			} else if (max == alpha[i]) {
				idx = -1;
			}
		}
		if (idx < 0) {
			System.out.println("?");
		} else {
			System.out.println((char) ('A' + idx));
		}
	}

}

package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1316 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			boolean[] alpha = new boolean[26];
			int ch = -1;
			for (int j = 0; j < s.length(); j++) {
				int now = s.charAt(j) - 'a';
				if (!alpha[now]) { // 처음 등장
					ch = now;
					alpha[now] = true;
				} else { // 이미 등장
					if (ch != now) { // 연속 x
						ch = -1;
						break;
					}
				}
			}
			if (ch >= 0) {
				count += 1;
			}
		}
		System.out.println(count);
	}

}

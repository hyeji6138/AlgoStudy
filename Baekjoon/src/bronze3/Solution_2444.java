package bronze3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_2444 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		for (int i = 1; i <= N; i++) {
			for (int j = N - i; j > 0; j--) {
				bw.write(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		for (int i = N - 1; i > 0; i--) {
			for (int j = N - i; j > 0; j--) {
				bw.write(" ");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		bw.flush();
	}

}

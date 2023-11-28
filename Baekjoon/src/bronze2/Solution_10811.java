package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10811 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] array = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			array[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			for (int j = 0; j < (e - s + 1) / 2; j++) {
				int temp = array[s + j];
				array[s + j] = array[e - j];
				array[e - j] = temp;
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(array[i] + " ");
		}
	}

}

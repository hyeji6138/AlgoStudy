package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2884 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		if (hour == 0) {
			hour = 24;
		}
		int alram = hour * 60 + minute - 45;
		hour = alram / 60;
		minute = alram % 60;
		if (hour == 24) {
			hour = 0;
		}
		System.out.println(hour + " " + minute);
	}

}

package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuffer sb = new StringBuffer(st.nextToken());
		int a = Integer.parseInt(sb.reverse().toString());
		sb = new StringBuffer(st.nextToken());
		int b = Integer.parseInt(sb.reverse().toString());

		System.out.println(Math.max(a, b));
	}

}

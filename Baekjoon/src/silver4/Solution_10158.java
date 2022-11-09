package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10158 {
	static int w, h, p, q;
	static int t;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(br.readLine());
		// ==============입력 끝===================
		int pt = (p + t) % (w * 2);
		int qt = (q + t) % (h * 2);

		if (pt > w) pt = w * 2 - pt;
		if (qt > h) qt = h * 2 - qt;

		System.out.println(pt + " " + qt);
	}
}

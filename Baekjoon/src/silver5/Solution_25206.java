package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_25206 {
	static HashMap<String, Double> hash = new HashMap<String, Double>() {
		{
			put("A+", 4.5);
			put("A0", 4.0);
			put("B+", 3.5);
			put("B0", 3.0);
			put("C+", 2.5);
			put("C0", 2.0);
			put("D+", 1.5);
			put("D0", 1.0);
			put("F", 0.0);
			put("P", 0.0);
		}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double sum = 0;
		double cnt = 0;
		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String class_name = st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String score = st.nextToken();

			sum += credit * hash.get(score);
			if (!score.equals("P")) {
				cnt += credit;
			}
		}
		System.out.println(sum / cnt);
	}

}

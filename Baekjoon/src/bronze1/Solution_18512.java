package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_18512 { // 점프 점프
	static int P1, P2, X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		P1 = Integer.parseInt(st.nextToken());
		P2 = Integer.parseInt(st.nextToken());

		int A = P1, B = P2;
		int answer = -1;
		int cnt = 0;
		while(cnt < 10000) {
			if(A > B) {
				B += Y;
			}else if(A < B){
				A += X;
			}else {
				answer = A;
				break;
			}
			cnt++;
		}
		System.out.println(answer);
	}

}

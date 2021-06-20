package sliver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14501 { // 퇴사
	static int N, answer;
	static int[] T, P, array;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		// =====================입력 끝=============================
		array = new int[N];
		go(0,0);
		System.out.println(answer);
	}
	
	public static void go(int idx, int sum) {
		if(idx >= N) {
			answer = Math.max(answer, sum);
			return ;
		}
		if(idx+T[idx] <= N) {
			array[idx] = 1;
			go(idx+T[idx], sum+P[idx]);			
		}
		array[idx] = 0;
		go(idx+1, sum);
	}

}

package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14889 { // 스타트와 링크
	static int N, answer;
	static int[][] S;
	static int[] team;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// =====================입력 끝==========================
		team = new int[N];
		answer = Integer.MAX_VALUE;
		makeTeam(0,0);
		System.out.println(answer);
	}
	public static void makeTeam(int cnt, int idx) {
		if(idx == N) {
			if(cnt == N/2) {
				int[] teamScore = new int[2];
 				for(int i=0;i<N-1;i++) {
					for(int j=i+1;j<N;j++) {
						if(team[i] == team[j]) {
							teamScore[team[i]] += S[i][j]+S[j][i];
						}
					}
				}
				answer = Math.min(answer, Math.abs(teamScore[0]-teamScore[1]));
			}
			return ;
		}
		
		team[idx] = 1;
		makeTeam(cnt+1, idx+1);
		team[idx] = 0;
		makeTeam(cnt, idx+1);
	}
}

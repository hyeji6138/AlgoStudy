package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_카카오프렌즈컬러링북 {
	public static void main(String[] args) {
		int m = 6, n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };
		System.out.println(Arrays.toString(solution(m, n, picture)));
	}

	public static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
		
		boolean[][] visit = new boolean[m][n];
		Queue<Integer> q = new LinkedList<Integer>();
		int[] di = {-1,1,0,0}, dj= {0,0,-1,1};
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(picture[i][j] != 0 && !visit[i][j]) {
					q.add(i*n+j);
					visit[i][j] = true;
					int s = 1;
					while(!q.isEmpty()) {
						int now = q.poll();
						
						for(int d=0;d<4;d++) {
							int ni = now/n+di[d];
							int nj = now%n+dj[d];
							
							if(ni >= 0 && ni < m && nj >= 0 && nj < n && !visit[ni][nj] && picture[ni][nj] == picture[now/n][now%n]) {
								s++;
								visit[ni][nj] = true;
								q.add(ni*n+nj);
							}
						}
					}
					numberOfArea++;
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, s);
				}
			}
		}
		
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}

}

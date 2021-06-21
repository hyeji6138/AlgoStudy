package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_17140 {
	static int r, c, k, answer;
	
	public static void main(String[] args) throws IOException { // 이차원 배열과 연산
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int[][] map = new int[3][3];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rCnt = 3, cCnt = 3;
		answer = 0;
		//======================입력 끝=========================
		while(true) {
			if((r-1 < rCnt && c-1 < cCnt && map[r-1][c-1] == k) || answer > 100) break;
			if(rCnt >= cCnt) { // R연산
				int[] numCnt = new int[rCnt];
				int maxCnt = 0;
				Queue<Num> queue = new LinkedList<Num>();
				PriorityQueue<Num> q = new PriorityQueue<Num>();
				for(int i=0;i<rCnt;i++) {
					int[] num = new int[101];
					for(int j=0;j<cCnt;j++) {
						num[map[i][j]]++;
					}
					for(int j=1;j<=100;j++) {
						if(num[j] != 0) {
							q.add(new Num(j, num[j]));
							numCnt[i]++;
						}
					}
					if(numCnt[i] == 0) {
						rCnt = i;
						break;
					}
					while(!q.isEmpty()) {
						queue.add(q.poll());
					}
					maxCnt = Math.max(maxCnt, numCnt[i]);
				}
				map = new int[rCnt][maxCnt*2];
				for(int i=0;i<rCnt;i++) {
					for(int j=0, idx=0;j<numCnt[i];j++, idx+=2) {
						Num n = queue.poll();
						map[i][idx] = n.num;
						map[i][idx+1] = n.cnt;
					}
				}
				cCnt = maxCnt*2;
			}else { // C연산
				int[] numCnt = new int[cCnt];
				int maxCnt = 0;
				Queue<Num> queue = new LinkedList<Num>();
				PriorityQueue<Num> q = new PriorityQueue<Num>();
				for(int j=0;j<cCnt;j++) {
					int[] num = new int[101];
					for(int i=0;i<rCnt;i++) {
						num[map[i][j]]++;
					}
					for(int i=1;i<=100;i++) {
						if(num[i] != 0) {
							q.add(new Num(i, num[i]));
							numCnt[j]++;
						}
					}
					if(numCnt[j] == 0) {
						cCnt = j;
						break;
					}
					while(!q.isEmpty()) {
						queue.add(q.poll());
					}
					maxCnt = Math.max(maxCnt, numCnt[j]);
				}
				map = new int[maxCnt*2][cCnt];
				for(int j=0;j<cCnt;j++) {
					for(int i=0, idx=0;i<numCnt[j];i++, idx+=2) {
						Num n = queue.poll();
						map[idx][j] = n.num;
						map[idx+1][j] = n.cnt;
					}
				}
				rCnt = maxCnt*2;
			}
			
			if(rCnt > 100 || cCnt > 100) {
				int[][] temp = map;
				map = new int[Math.min(100, rCnt)][Math.min(100, cCnt)];
				
				for(int i=0;i<map.length;i++) {
					for(int j=0;j<map[i].length;j++) {
						map[i][j] = temp[i][j];
					}
				}
			}
			answer++;
		}
		if(answer > 100) System.out.println(-1);
		else System.out.println(answer);

	}
	public static void printArray(int[][] map) {
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	static class Num implements Comparable<Num>{
		int num, cnt;
		Num(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Num o) {
			if(this.cnt == o.cnt) {
				return this.num-o.num;
			}
			return this.cnt-o.cnt;
		}
		
		@Override
		public String toString() {
			return "("+this.num+" "+this.cnt+")";
		}
		
	}

}

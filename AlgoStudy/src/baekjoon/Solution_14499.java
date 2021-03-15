package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14499 {
	static int N, M, x, y, K;
	static int[][] map;
	static int[] move;
	static int[] dice = {0,0,0,0,0,0};
	static int[][] turn = {{0,1,2,3,4,5},{3,1,0,5,4,2},{2,1,5,0,4,3},{4,0,2,3,5,1},{1,5,2,3,0,4}};
	static int[] di = {0,0,0,-1,1}, dj= {0,1,-1,0,0}; // 0�����ϳ�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		move = new int[K];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			move[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<K;i++) {
			int nx = x+ di[move[i]];
			int ny = y+ dj[move[i]];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue; //���� ���̸�
			
			turning(move[i]); //�ֻ��� ȸ��
			
			if(map[nx][ny] != 0) { // ���� ���� 0�� �ƴϸ� ������ �ֻ��� �ٴڿ� ����
				dice[5] = map[nx][ny];
				map[nx][ny] = 0;
			}else{// ���� ���� 0�̸� �ֻ��� �ٴ��� ������ ����
				map[nx][ny] = dice[5];
			}
			x = nx;
			y = ny;
			sb.append(dice[0]+"\n");
		}
		System.out.println(sb.toString());
	}
	static void turning(int d) {
		int[] temp = new int[6];
		for(int i=0;i<6;i++) {
			temp[i] = dice[turn[d][i]];
		}
		dice = temp;
	}
}

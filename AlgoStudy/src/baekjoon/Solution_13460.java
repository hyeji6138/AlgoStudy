package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_13460 {
	static int N, M, answer;
	static char board[][];
	static boolean visit[][][][];
	static Point red, blue, goal;
	static int[] di = {0,1,0,-1}; //�����»�
	static int[] dj = {1,0,-1,0}; //�����»�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ������ ���� ����
		M = Integer.parseInt(st.nextToken()); // ������ ���� ����
		board = new char[N][M];
		visit = new boolean[N][M][N][M];
		answer = 0;
		// ���� ���� ����, ���� ����, �Ķ� ����, ���� ��ġ ����
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				board[i][j] = temp.charAt(j);
				if(board[i][j] == 'R') red = new Point(i,j);
				else if(board[i][j] == 'B') blue = new Point(i,j);
				else if(board[i][j] == 'O') goal = new Point(i,j);
			}
		}
		bfs();
		System.out.println(answer);
		
	}
	static void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		
		queue.add(new Point(red.i, red.j));
		queue.add(new Point(blue.i, blue.j));
		visit[red.i][red.j][blue.i][blue.j] = true;
		
		boolean r_check = false; // ���� ���� Ż�� ����
		// ���� �����̱�
		for(int i=0;i<10;i++) { //�ִ� 10��
			if(!queue.isEmpty()) {
				int size = queue.size();
				for(int j=0;j<size/2;j++) { //�ѹ� �̵��� ����� ��� ����Ʈ �� ������
					Point r = queue.poll();
					Point b = queue.poll();
					for(int d=0;d<4;d++) {
						Point nr = new Point(r.i, r.j);
						Point nb = new Point(b.i, b.j);
						
						int bm = move(nb,d); //�Ķ� ���� ���� �̵�
						if(board[nb.i][nb.j] == 'O') { //�Ķ� ������ ���ۿ� ������ ��� ����
							continue;
						}
						int rm = move(nr,d);//���� ���� �̵�
						if(board[nr.i][nr.j] == 'O') { //���� ���� ���ۿ� ������ ����, �ݺ��� ������
							r_check = true;
							break;
						}
						
						if(nb.i == nr.i && nb.j == nr.j) { //�� ������ ���� ��ġ�� �����ϸ� �� ���� ������ ������ ��ĭ �ڷ� �̵�
							if(bm > rm) {
								nb.i -= di[d];
								nb.j -= dj[d];
							}else {
								nr.i -= di[d];
								nr.j -= dj[d];
							}
						}
						
						if(!visit[nr.i][nr.j][nb.i][nb.j]) { //���� �� ������ ��ġ�� ������ ���� ����̸� ť�� �߰�
							queue.add(nr);
							queue.add(nb);
							visit[nr.i][nr.j][nb.i][nb.j] = true;
						}
					} //����
					if(r_check) break;
				} // ���� ��ġ
			} //if
			answer++; //�̵� Ƚ�� ����
			if(r_check) break;
		}// 10��
		if(!r_check) answer = -1; //10���� �̵����� ���� ������ Ż������ �������� -1
	}
	// ���̳� ���۸����� ������ �̵�
	static int move(Point p, int d) {
		int move_dist = 0;
		while(true) {
			int ni = p.i+di[d];
			int nj = p.j+dj[d];
			
			if(board[ni][nj]=='#') break;
			p.i = ni;
			p.j = nj;
			move_dist++;
			if(board[ni][nj] == 'O') break;
		}
		return move_dist;
	}
	
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i= i;
			this.j = j;
		}
	}

}

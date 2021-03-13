package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * ���� ���ٴϴµ� ����� ������ �� ���̰� �þ
 * �� �Ǵ� �ڱ� �ڽ��� ���� �ε����� ������ ����
 * ���� �����¿� ���� ��
 * N*N ���簢 ���� ������ ���� (0<=N<=100)
 * ��� (0<=K<=100)
 * ������ �� ���� ������������ ��ġ, �� ���� 1, ó���� ���������� ����
 * -���� �����̸� �÷� �Ӹ��� ���� ĭ�� ��ġ��Ų��
 * -�̵��� ĭ�� ����� �ִٸ� ����� �������� ������ �������� �ʴ´�
 * -�̵��� ĭ�� ����� ���ٸ� �����̸� �ٿ��� ������ ��ġ�� ĭ�� ����ش�
 * ����� ��ġ�� ���� �̵���ΰ� �־����� ���ʿ� �������� ���
 * (1,1)���� ��� x
 * �� ���� ��ȯ Ƚ�� L (1<=L<=100)
 * ���� ���� �ð����κ��� x�ʰ� ���� �ڿ� ('L','D)����, ���������� 90�� ȸ����Ų�ٴ� �� (x<=10000)
 * */
public class Solution_3190 {
	static int N, K, L, answer;
	static int[][] board, move;
	static List<Point> snake;
	static int[] di = {0,1,0,-1}; //�����»�
	static int[] dj = {1,0,-1,0}; //�����»�
	static Point snakeHead, snakeTail;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //���� ũ��
		K = Integer.parseInt(br.readLine()); //��� ����
		snake = new ArrayList<Point>(); //��
		board = new int[N][N];
		answer = 0;
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int ai = Integer.parseInt(st.nextToken());
			int aj = Integer.parseInt(st.nextToken());
			board[ai-1][aj-1] = 1; //���忡 ���ǥ��
		}
		L = Integer.parseInt(br.readLine()); //�̵� Ƚ��
		move = new int[L][2];
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			char temp = st.nextToken().charAt(0);
			move[i][1] = temp=='D'?1:0; //���� ȸ�� 0, ������ ȸ�� 1
		}
		
		//------------------------����-----------------------------
		snake.add(new Point(0,0));
		snakeHead = snake.get(0);
		snakeTail = snake.get(0);
		board[0][0] = 2; //���ִ� ĭ ǥ��
		
		boolean end = false;
		int d = 0;
		for(int i=0;i<L;i++) {
			for(int t=answer;t<move[i][0];t++) { //���� ȸ������ ���� �̵� �������� ���̵� (������ ���� ���� �ð����� ����)
				end = go(d);
				if(end) break;
			}
			//���� ��ȯ
			d = move[i][1]==0?(d+3)%4:(d+1)%4;
			if(end) break;
		}
		while(!end) {
			end = go(d);
		}
		System.out.println(answer+1);
		
	}
	static boolean go(int d) {
		int ni = snakeHead.i+di[d];
		int nj = snakeHead.j+dj[d];
		if(ni>=0 && ni<N && nj>=0 && nj<N && board[ni][nj] != 2) {
			//���� �̵��� ĭ�� ���� �ƴϰ� �� ���� �ƴϸ�
			//��� �̵�
			Point newHead = new Point(ni,nj);
			snake.add(0, newHead);
			snakeHead = newHead;
			if(board[ni][nj]!=1) {//�̵��� ĭ�� ����� ������
				//���� �̵�
				board[snakeTail.i][snakeTail.j] = 0;
				snake.remove(snake.size()-1);
				snakeTail = snake.get(snake.size()-1);
				
			}
			board[ni][nj] = 2;
		}else {
			return true;
		}
		answer++; //�ð� ����
		return false;
	}
	static class Point{
		int i, j;
		Point(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
}

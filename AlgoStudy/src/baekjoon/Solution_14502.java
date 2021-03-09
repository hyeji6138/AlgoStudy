package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_14502 {
	static int N, M, answer; // ������ ũ��, �������� ��  �ִ�
	static int[][] lab; // ������
	static List<Integer> wall; // �� ���� �� �ִ� ��ġ
	static int[] pick; // �� ���� �� ����
	static int[] di = { -1, 1, 0, 0 }; // �����¿�
	static int[] dj = { 0, 0, -1, 1 }; // �����¿�

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // ������ ����
		M = Integer.parseInt(st.nextToken()); // ������ ����
		lab = new int[N][M]; // ������ �ʱ�ȭ
		wall = new ArrayList<Integer>(); // �� ���� �� �ִ� ��
		pick = new int[3]; // �� ���� 3�� ����
		answer = Integer.MIN_VALUE; // �ִ밪�� ���ؾ��ϴϱ� �ּҰ��� ����
		// ������ ���� ����
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 0) { // �� ���� �� ����
					wall.add(i * M + j);
				}
			}
		}
		go(0, 0); // �� ���� �� ���ϸ鼭 �ù� ����
		System.out.println(answer);

	}
	// ���� ���� �� ����
	public static int areaCnt(int[][] lab) {
		Queue<Point> q = new LinkedList<Point>(); // ���̷��� ��ġ
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 2) { //���̷����̸� ���� ��ġ ����
					q.add(new Point(i, j));
				}
			}
		}
		while (!q.isEmpty()) { //���̷����� ���̻� ������ ���� ������
			Point now = q.poll();
			for (int d = 0; d < 4; d++) {
				// ���̷����� �������� ���� ��ġ
				int ni = now.i + di[d];
				int nj = now.j + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < M && lab[ni][nj] == 0) { //���� �� �ִ� ����� ������
					lab[ni][nj] = 2; //������
					q.add(new Point(ni, nj)); //�� ���� �� �����ϱ� ť�� ����
				}
			}
		}
		int cnt = 0; // �������� ��
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) // �������� �̸� ī��Ʈ ����
					cnt++;
			}
		}
		return cnt;
	}
	// 3���� ���� ���� �� �ִ� ����� �� �� Ž��
	public static void go(int cur, int cnt) {
		if (cnt == 3) {// �� ���� �� �� ����
			int[][] new_lab = new int[N][M]; //���̷��� �ù� ���� ������ ���� ����� - ���� �Ȱǵ帮����
			for (int ki = 0; ki < N; ki++) {
				for (int kj = 0; kj < M; kj++) {
					new_lab[ki][kj] = lab[ki][kj];
				}
			}
			// ������ ���� �� �����
			for (int i = 0; i < 3; i++) {
				int wall_i = pick[i] / M; // �� ���� i
				int wall_j = pick[i] % M; // �� ���� j

				new_lab[wall_i][wall_j] = 1;
			}
			int aCnt = areaCnt(new_lab); // �������� �� ���ϱ�
			answer = Math.max(answer, aCnt); // �������� �� �ִ밪 ���ϱ� 
			return;
		}
		// �ߺ�x �������� �� ���� �� ���� 
		for (int i = cur; i < wall.size(); i++) {
			pick[cnt] = wall.get(i);
			go(i + 1, cnt + 1);
		}
	}

	static class Point {
		int i, j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

}

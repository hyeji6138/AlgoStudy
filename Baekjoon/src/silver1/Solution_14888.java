package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_14888 { // 연산자 끼워넣기
	static int N, max, min;
	static int[] num, opCnt, op, array;
	static boolean[] select;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		opCnt = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			opCnt[i] = Integer.parseInt(st.nextToken());
			cnt += opCnt[i];
		}
		op = new int[cnt];
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < opCnt[i]; j++) {
				op[idx++] = i;
			}
		}
		select = new boolean[op.length];
		array = new int[op.length];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		// ==================입력 끝====================
		perm(0);
		System.out.println(max);
		System.out.println(min);

	}

	public static void perm(int cnt) {
		if (cnt == op.length) {
			int a = num[0], b = 0;
			for (int i = 0; i < op.length; i++) {
				b = num[i+1];
				if (op[array[i]] == 0) {
					a += b;
				} else if (op[array[i]] == 1) {
					a -= b;
				} else if (op[array[i]] == 2) {
					a *= b;
				} else {
					a /= b;
				}
			}
			max = Math.max(max, a);
			min = Math.min(min, a);
			return;
		}

		for (int i = 0; i < op.length; i++) {
			if (!select[i]) {
				array[cnt] = i;
				select[i] = true;
				perm(cnt + 1);
				select[i] = false;
			}
		}

	}

}

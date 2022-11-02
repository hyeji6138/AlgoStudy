package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Stack;

public class Solution_16637 {
	static int N, answer;
	static int[] select, num;
	static char[] op;
	static StringBuffer sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] text = br.readLine().toCharArray();
		num = new int[N / 2 + 1];
		op = new char[N / 2];
		answer = Integer.MIN_VALUE;
		for (int i = 0, n = 0, o = 0; i < text.length; i++) {
			if (i % 2 == 0) num[n++] = text[i] - '0';
			else op[o++] = text[i];
		}
		calculate(0, num[0]);

//		sb = new StringBuffer(br.readLine());
//		answer = Integer.MIN_VALUE;
//		for (int i = 0; i <= N / 4; i++) {
//			select = new int[i];
//			comb(0, 0, i, N / 2);
//		}
		System.out.println(answer);
	}

	public static void calculate(int cnt, int result) {
		if (cnt == N / 2) {
			answer = Math.max(answer, result);
			return;
		}

		calculate(cnt + 1, operation(result, num[cnt + 1], op[cnt]));
		if (cnt + 1 < N / 2) {
			calculate(cnt + 2, operation(result, operation(num[cnt + 1], num[cnt + 2], op[cnt + 1]), op[cnt]));
		}

	}

	public static int operation(int a, int b, char op) {
		if (op == '+') {
			return a + b;
		} else if (op == '-') {
			return a - b;
		} else {
			return a * b;
		}
	}

//	public static void comb(int cnt, int cur, int num, int op) {
//		if (cnt == num) {
//			int[] loc = new int[N / 2];
//			for (int i = 0; i < N / 2; i++) {
//				loc[i] = i * 2 + 1;
//			}
//			StringBuffer stringBuffer = new StringBuffer(sb);
//			for (int i = 0; i < num; i++) {
//				stringBuffer.insert(loc[select[i]] - 1, '(');
//				for (int j = select[i]; j < N / 2; j++) {
//					loc[j]++;
//				}
//				stringBuffer.insert(loc[select[i]] + 2, ')');
//				for (int j = select[i] + 1; j < N / 2; j++) {
//					loc[j]++;
//				}
//			}
//
//			int result = calculate(stringBuffer.toString());
//			answer = Math.max(answer, result);
//
//			return;
//		}
//
//		for (int i = cur; i < op; i++) {
//			select[cnt] = i;
//			comb(cnt + 1, i + 2, num, op);
//		}
//	}
//
//	public static int calculate(String text) {
//		char[] textList = text.toCharArray();
//		Stack<Integer> num = new Stack<>();
//		Stack<Character> operator = new Stack<>();
//		boolean bracket = false;
//		for (int i = 0; i < textList.length; i++) {
//			if (textList[i] - '0' >= 0 && textList[i] - '0' <= 9) { // 숫자
//				num.push(textList[i] - '0');
//			} else {
//				if (textList[i] == '(') {
//					bracket = true;
//					operator.push(textList[i]);
//				} else if (textList[i] == ')') {
//					while (true) {
//						char op = operator.pop();
//						if (op == '(') break;
//
//						int a = num.pop();
//						int b = num.pop();
//
//						num.push(operation(a, b, op));
//					}
//					bracket = false;
//				} else {
//					operator.push(textList[i]);
//				}
//			}
//			if (num.size() >= 2 && !bracket) {
//				char op = operator.pop();
//				int a = num.pop();
//				int b = num.pop();
//				num.push(operation(a, b, op));
//			}
//		}
//
//		while (!operator.isEmpty()) {
//			char op = operator.pop();
//			int a = num.pop();
//			int b = num.pop();
//
//			num.push(operation(a, b, op));
//		}
//
//		return num.pop();
//	}
//
//	public static int operation(int a, int b, char op) {
//		if (op == '+') {
//			return b + a;
//		} else if (op == '-') {
//			return b - a;
//		} else {
//			return b * a;
//		}
//	}

}

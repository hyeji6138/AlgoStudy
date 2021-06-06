package gold3;

import java.util.Scanner;

public class Solution_1030 { // 프렉탈 평면
	static int[] input;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[7];
		for (int i = 0; i < 7; i++) {
			input[i] = sc.nextInt();
		}
		sc.close();
		// ==============입력 끝=====================
		
		// 메모리 초과 - 규칙성을 찾아서 이차원 배열 안만들고 해결해야 할 듯
		map = new int[1][1];
		for (int s = 1; s <= input[0]; s++) {
			int[][] newMap = new int[(int)Math.pow(input[1], s)][(int)Math.pow(input[1], s)];
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j] == 0) {
						int stdI = i*input[1]+(input[1]/2-input[2]/2);
						int stdJ = j*input[1]+(input[1]/2-input[2]/2);
						for(int ni = stdI;ni < stdI+input[2];ni++) {
							for(int nj = stdJ;nj < stdJ+input[2];nj++) {
								newMap[ni][nj] = 1;
							}
						}
					}else {
						int stdI = i*input[1];
						int stdJ = j*input[1];
						for(int ni = stdI;ni < stdI+input[1];ni++) {
							for(int nj = stdJ;nj < stdJ+input[1];nj++) {
								newMap[ni][nj] = 1;
							}
						}
					}
				}
			}
			map = newMap;
		}
		StringBuffer sb = new StringBuffer();
		for(int i=input[3];i<=input[4];i++) {
			for(int j=input[5];j<=input[6];j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}

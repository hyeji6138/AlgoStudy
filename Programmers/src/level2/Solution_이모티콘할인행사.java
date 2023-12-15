package level2;

import java.util.Arrays;

public class Solution_이모티콘할인행사 {
	static int[] sale, answer;

	public static void main(String[] args) {
		int[][] users = { { 40, 10000 }, { 25, 10000 } };
		int[] emoticons = { 7000, 9000 };
		System.out.println(Arrays.toString(solution(users, emoticons)));
	}

	static public int[] solution(int[][] users, int[] emoticons) {
		answer = new int[2];
		sale = new int[emoticons.length];
		saleEmoticons(0, emoticons.length, users, emoticons);
		return answer;
	}

	static public void countMoney(int[][] users, int[] emoticons) {
		int plus = 0;
		int total = 0;
		for (int i = 0; i < users.length; i++) {
			int sum = 0;
			for (int j = 0; j < emoticons.length; j++) {
				if (users[i][0] <= sale[j]) {
					sum += emoticons[j] * (100 - sale[j]) / 100;
				}
			}
			if (users[i][1] <= sum) {
				plus += 1;
			} else {
				total += sum;
			}
		}
		if (answer[0] < plus) {
			answer[0] = plus;
			answer[1] = total;
		} else if (answer[0] == plus && answer[1] < total) {
			answer[1] = total;
		}
	}

	static public void saleEmoticons(int cnt, int n, int[][] users, int[] emoticons) {
		if (cnt == n) {
			countMoney(users, emoticons);
			return;
		}

		for (int i = 10; i < 50; i += 10) {
			sale[cnt] = i;
			saleEmoticons(cnt + 1, n, users, emoticons);
		}
	}

}

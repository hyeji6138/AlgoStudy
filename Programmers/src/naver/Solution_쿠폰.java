package naver;

import java.util.Arrays;
/* 2021.07.04 네이버웹툰 개발 챌린지 1차 코딩 테스트 (Back-End) 1번*/
public class Solution_쿠폰 {
	public static void main(String[] args) {
		// [13000, 88000, 10000], [30, 20]
		// [32000, 18000, 42500], [50, 20, 65]
		int[] prices = { 32000, 18000, 42500 }, discounts = { 50, 20, 65 };
		System.out.println(solution(prices, discounts));
	}

	public static int solution(int[] prices, int[] discounts) {
		int answer = 0;
		Arrays.sort(prices);
		Arrays.sort(discounts);

		for (int p = prices.length - 1, d = discounts.length - 1; p >= 0; p--) {
			if (d >= 0) {
				answer += prices[p] * (100 - discounts[d]) / 100;
				d--;
			} else {
				answer += prices[p];
			}
		}

		return answer;
	}
}

package level1;

public class Solution_부족한금액계산하기 {
	public static void main(String[] args) {
		int price = 3;
		int money = 50;
		int count = 4;
		System.out.println(solution(price, money, count));
	}

	public static long solution(int price, int money, int count) {
		long answer = -1;
		long pay = 0;
		for (int i = 1; i <= count; i++) {
			pay += price * i;
		}
		answer = pay - money;
		if (answer <= 0) {
			answer = 0;
		}

		return answer;
	}
}

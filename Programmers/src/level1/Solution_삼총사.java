package level1;

public class Solution_삼총사 {
	static int answer;
	static int[] select;

	public static void main(String[] args) {
		int[] number = { -1, 1, -1, 1 };
		System.out.println(solution(number));
	}

	public static int solution(int[] number) {
		select = new int[3];
		comb(0, 0, 3, number);
		return answer;
	}

	public static void comb(int cnt, int cur, int num, int[] number) {
		if (cnt == num) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += number[select[i]];
			}
			if (sum == 0) {
				answer++;
			}
			return;
		}

		for (int i = cur; i < number.length; i++) {
			select[cnt] = i;
			comb(cnt + 1, i + 1, num, number);
		}
	}
}

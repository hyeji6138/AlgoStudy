package level0;

public class Solution_이어붙인수 {
	public static void main(String[] args) {
		int[] num_list = { 3, 4, 5, 2, 1 };
		System.out.println(solution(num_list));
	}

	public static int solution(int[] num_list) {
		int answer = 0;
		int odd = 0, even = 0;
		for (int i = 0; i < num_list.length; i++) {
			if (num_list[i] % 2 == 0) {
				even = even * 10 + num_list[i];
			} else {
				odd = odd * 10 + num_list[i];
			}
		}
		answer = even + odd;
		return answer;
	}

}

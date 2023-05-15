package level0;

public class Solution_1로만들기 {
	public static void main(String[] args) {
		int[] num_list = { 12, 4, 15, 1, 14 };
		System.out.println(solution(num_list));
	}

	public static int solution(int[] num_list) {
		int answer = 0;
		for (int i = 0; i < num_list.length; i++) {
			int n = num_list[i];
			while (n > 1) {
				if (n % 2 != 0) {
					n -= 1;
				}
				n /= 2;
				answer++;
			}
		}
		return answer;
	}

}

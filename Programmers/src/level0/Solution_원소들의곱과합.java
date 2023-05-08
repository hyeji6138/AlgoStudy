package level0;

public class Solution_원소들의곱과합 {
	public static void main(String[] args) {
		int[] num_list = { 3, 4, 5, 2, 1 };
		System.out.println(solution(num_list));
	}

	public static int solution(int[] num_list) {
		int answer = 0;
		int mul = 1, sum = 0;
		for (int i = 0; i < num_list.length; i++) {
			mul *= num_list[i];
			sum += num_list[i];
		}
		if (mul < sum * sum) {
			answer = 1;
		}
		return answer;
	}

}

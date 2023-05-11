package level0;

public class Solution_홀수vs짝수 {
	public static void main(String[] args) {
		int[] num_list = { 4, 2, 6, 1, 7, 6 };
		System.out.println(solution(num_list));

	}

	public static int solution(int[] num_list) {
		int answer = 0;
		int[] sum = new int[2];
		for (int i = 0; i < num_list.length; i++) {
			sum[i % 2] += num_list[i];
		}
		answer = Math.max(sum[0], sum[1]);
		return answer;
	}

}

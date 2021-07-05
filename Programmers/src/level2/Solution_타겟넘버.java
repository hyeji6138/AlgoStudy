package level2;

public class Solution_타겟넘버 {
	public static void main(String[] args) {
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;
		answer = count(target, numbers, 0, 0);
		return answer;
	}
	
	public static int count(int target, int[] numbers, int idx, int sum) {
		if(idx == numbers.length) {
			if(sum == target) return 1;
			return 0;
		}
		int cnt = 0;
		cnt += count(target, numbers, idx+1, sum+numbers[idx]);
		cnt += count(target, numbers, idx+1, sum-numbers[idx]);
		
		return cnt;
	}
}

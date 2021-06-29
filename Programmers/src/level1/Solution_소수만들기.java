package level1;

public class Solution_소수만들기 {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 6, 4 };
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (isPrime(nums[i] + nums[j] + nums[k])) answer++;
				}
			}
		}
		return answer;
	}

	public static boolean isPrime(int num) {
		int cnt = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) cnt++;
		}
		if (cnt == 2) return true;
		return false;

	}

	public static int comb(int cnt, int cur, int[] nums, int[] select, int answer) {
		if (cnt == 3) {
			int num = 0;
			for (int i = 0; i < 3; i++) {
				num += select[i];
			}
			if (isPrime(num)) return answer + 1;
			return answer;
		}

		for (int i = cur; i < nums.length; i++) {
			select[cnt] = nums[i];
			answer = comb(cnt + 1, i + 1, nums, select, answer);
		}
		return answer;
	}

}

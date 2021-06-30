package level1;

import java.util.HashSet;

public class Solution_폰켓몬 {
	public static void main(String[] args) {
		int[] nums = {};
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		int answer = 0;
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!hash.contains(nums[i])) hash.add(nums[i]);
		}

		if (hash.size() < (nums.length / 2)) answer = hash.size();
		else answer = nums.length / 2;
		return answer;
	}

}

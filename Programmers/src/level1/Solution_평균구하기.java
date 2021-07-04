package level1;

public class Solution_평균구하기 {
	public static void main(String[] args) {
		int[] arr = {};
		System.out.println(solution(arr));
	}

	public static double solution(int[] arr) {
		double answer = 0;
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		answer = answer / arr.length;
		return answer;
	}
}

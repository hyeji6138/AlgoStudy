package level0;

public class Solution_가까운1찾기 {
	public static void main(String[] args) {
		int[] arr = { 1, 0, 0, 1, 0, 0 };
		int idx = 4;
		System.out.println(solution(arr, idx));
	}

	public static int solution(int[] arr, int idx) {
		int answer = -1;
		for (int i = idx; i < arr.length; i++) {
			if (arr[i] == 1) {
				answer = i;
				break;
			}
		}
		return answer;
	}
}

package level0;

public class Solution_조건에맞게수열변환하기2 {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 100, 99, 98 };
		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int answer = 0;
		boolean change;
		do {
			change = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > 50 && arr[i] % 2 == 0) {
					change = true;
					arr[i] = arr[i] / 2;
				} else if (arr[i] < 50 && arr[i] % 2 != 0) {
					change = true;
					arr[i] = arr[i] * 2 + 1;
				}
			}
			if (change) {
				answer += 1;
			}
		} while (change);
		return answer;
	}

}

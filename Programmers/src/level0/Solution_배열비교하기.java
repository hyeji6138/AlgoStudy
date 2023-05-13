package level0;

public class Solution_배열비교하기 {
	public static void main(String[] args) {
		int[] arr1 = { 49, 13 };
		int[] arr2 = { 70, 11, 2 };
		System.out.println(solution(arr1, arr2));
	}

	public static int solution(int[] arr1, int[] arr2) {
		int answer = 0;
		if (arr1.length != arr2.length) {
			answer = arr1.length > arr2.length ? 1 : -1;
		} else {
			int[] sum = new int[2];
			for (int i = 0; i < arr1.length; i++) {
				sum[0] += arr1[i];
				sum[1] += arr2[i];
			}
			if (sum[0] != sum[1]) {
				answer = sum[0] > sum[1] ? 1 : -1;
			}
		}
		return answer;
	}

}

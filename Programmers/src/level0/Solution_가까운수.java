package level0;

public class Solution_가까운수 {
	public static void main(String[] args) {
		int[] array = { 3, 10, 28 };
		int n = 20;
		System.out.println(solution(array, n));
	}

	public static int solution(int[] array, int n) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			int dist = Math.abs(n - array[i]);
			if (min > dist) {
				min = dist;
				answer = array[i];
			} else if (min == dist && answer > array[i]) {
				answer = array[i];
			}
		}
		return answer;
	}

}

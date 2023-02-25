package level0;

public class Solution_7의개수 {
	public static void main(String[] args) {
		int[] array = { 7, 77, 17 };
		System.out.println(solution(array));
	}

	public static int solution(int[] array) {
		int answer = 0;
		for (int i = 0; i < array.length; i++) {
			while (array[i] > 0) {
				if (array[i] % 10 == 7) {
					answer++;
				}
				array[i] /= 10;
			}
		}
		return answer;
	}

}

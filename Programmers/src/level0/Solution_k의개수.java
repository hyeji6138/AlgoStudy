package level0;

public class Solution_k의개수 {
	public static void main(String[] args) {
		int i = 1, j = 13, k = 1;
		System.out.println(solution(i, j, k));
	}

	public static int solution(int i, int j, int k) {
		int answer = 0;
		for (int n = i; n <= j; n++) {
			int temp = n;
			while (temp > 0) {
				if (temp % 10 == k) {
					answer++;
				}
				temp = temp / 10;
			}
		}
		return answer;
	}

}

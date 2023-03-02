package level0;

public class Solution_최빈값구하기 {
	public static void main(String[] args) {
		int[] array = { 0, 0, 0, 1 };
		System.out.println(solution(array));
	}

	public static int solution(int[] array) {
		int answer = -1;
		int[] cnt = new int[1001];
		for (int i = 0; i < array.length; i++) {
			cnt[array[i]] += 1;
		}
		int maxCnt = 0;
		for (int i = 0; i <= 1000; i++) {
			if (maxCnt < cnt[i]) {
				answer = i;
				maxCnt = cnt[i];
			} else if (maxCnt == cnt[i]) {
				answer = -1;
			}
		}
		return answer;
	}

}

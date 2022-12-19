package level2;

public class Solution_피로도 {
	static boolean[] select;
	static int answer;

	public static void main(String[] args) {
		int k = 80;
		int[][] dungeons = { { 80, 20 }, { 50, 40 }, { 30, 10 }, { 20, 10 }, { 10, 10 }, { 60, 40 }, { 10, 10 },
				{ 20, 20 } };
		System.out.println(solution(k, dungeons));
	}

	public static int solution(int k, int[][] dungeons) {
		answer = 0;
		select = new boolean[dungeons.length];
		go(0, k, dungeons);
		return answer;
	}

	public static void go(int cnt, int k, int[][] dungeons) {
		for (int i = 0; i < dungeons.length; i++) {
			if (!select[i] && dungeons[i][0] <= k && dungeons[i][1] <= k) {
				select[i] = true;
				go(cnt + 1, k - dungeons[i][1], dungeons);
				select[i] = false;
			} else {
				answer = Math.max(answer, cnt);
			}
		}
	}
}

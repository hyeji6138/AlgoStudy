package level0;

public class Solution_숫자찾기 {
	public static void main(String[] args) {
		int num = 232443, k = 4;
		System.out.println(solution(num, k));
	}

	public static int solution(int num, int k) {
		int answer = -1;
		int cnt = 1;
		while (num / (cnt * 10) > 0) {
			cnt *= 10;
		}
		int idx = 1;
		while (cnt > 0) {
			System.out.println(num / cnt);
			if (num / cnt == k) {
				answer = idx;
				break;
			} else {
				num -= (num / cnt) * cnt;
				cnt /= 10;
				idx++;
			}
		}
		return answer;
	}

}

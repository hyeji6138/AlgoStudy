package level3;

public class Solution_기지국설치 {
	public static void main(String[] args) {
		int n = 200000000;
		int[] stations = { 3 };
		int w = 1;
		System.out.println(solution(n, stations, w));
	}

	public static int solution(int n, int[] stations, int w) {
		int answer = 0;
		int start = 1;
		for (int i = 0; i < stations.length; i++) {
			int dist = stations[i] - w - start;
			answer += dist / (1 + 2 * w);
			if (dist % (1 + 2 * w) != 0) {
				answer += 1;
			}
			start = stations[i] + w + 1;
		}
		if (start <= n) {
			int dist = n - start + 1;
			answer += dist / (1 + 2 * w);
			if (dist % (1 + 2 * w) != 0) {
				answer += 1;
			}
		}
		return answer;
	}

//	효율성 시간 초과
//	public static int solution(int n, int[] stations, int w) {
//		int answer = 0;
//		boolean[] apt = new boolean[n];
//		for (int i = 0; i < stations.length; i++) {
//			for (int j = -1 * w; j <= w; j++) {
//				int s = stations[i] - 1 + j;
//				if (s >= 0 && s < n) {
//					apt[s] = true;
//				}
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			if (!apt[i]) {
//				answer++;
//				i += 2 * w;
//			}
//		}
//		return answer;
//	}

}

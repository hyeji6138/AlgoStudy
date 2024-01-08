package level2;

public class Solution_조이스틱 {
	public static void main(String[] args) {
		String name = "BCAAAGF";
		System.out.println(solution(name));
	}

	static public int solution(String name) {
		int answer = 0;
		int n = name.length();
		for (int i = 0; i < n; i++) { // 알파벳 변경 횟수
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
		}
		int front = 0, end = 0; // front까지 정방향 탐색, end까지 역방향 탐색
		while (end < name.length() && name.charAt(end) == 'A') {
			end++;
		}
		int min = Integer.MAX_VALUE;
		while (end < name.length()) {
			int backDistance = name.length() - end; // 역방향 탐색거리
			int cost = front + backDistance; // 총 탐색 거리
			cost += Math.min(front, backDistance); // 더 짧은 거리를 먼저 탐색
			min = Math.min(min, cost); // 최소 탐색 거리
			front = end;
			do {
				end++;
			} while (end < name.length() && name.charAt(end) == 'A');

		}
		min = Math.min(front, min);
		answer += min;
		return answer;
	}

}

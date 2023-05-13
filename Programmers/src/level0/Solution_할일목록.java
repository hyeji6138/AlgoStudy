package level0;

import java.util.Arrays;

public class Solution_할일목록 {
	public static void main(String[] args) {
		String[] todo_list = { "problemsolving", "practiceguitar", "swim", "studygraph" };
		boolean[] finished = { true, false, true, false };
		System.out.println(Arrays.toString(solution(todo_list, finished)));
	}

	public static String[] solution(String[] todo_list, boolean[] finished) {
		int cnt = 0;
		for (int i = 0; i < finished.length; i++) {
			if (!finished[i]) {
				cnt++;
			}
		}
		String[] answer = new String[cnt];
		cnt = 0;
		for (int i = 0; i < finished.length; i++) {
			if (!finished[i]) {
				answer[cnt++] = todo_list[i];
			}
		}
		return answer;
	}

}

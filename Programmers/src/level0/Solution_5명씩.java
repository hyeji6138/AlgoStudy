package level0;

import java.util.Arrays;

public class Solution_5명씩 {
	public static void main(String[] args) {
		String[] names = { "nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx" };
		System.out.println(Arrays.toString(solution(names)));
	}

	public static String[] solution(String[] names) {
		String[] answer = new String[(names.length - 1) / 5 + 1];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = names[i * 5];
		}
		return answer;
	}
}

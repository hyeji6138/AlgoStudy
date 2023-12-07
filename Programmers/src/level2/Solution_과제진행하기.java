package level2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution_과제진행하기 {
	public static void main(String[] args) {
		String[][] plans = { { "korean", "11:40", "30" }, { "math", "12:30", "40" }, { "english", "12:10", "20" } };
		System.out.println(Arrays.toString(solution(plans)));
	}

	static public String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];
		Arrays.sort(plans, new MySort());
		PriorityQueue<String[]> queue = new PriorityQueue<String[]>(new MySort());
		for (int i = 0; i < plans.length; i++) {
			queue.add(plans[i]);
		}
		Stack<Project> stack = new Stack<Project>();
		int cnt = 0;
		while (!queue.isEmpty()) {
			String[] p = queue.poll();
			String[] next = queue.peek();
			if (next == null) {
				answer[cnt++] = p[0];
				break;
			}
			int start = timeToInt(p[1]);
			int playTime = Integer.parseInt(p[2]);
			int nextStart = timeToInt(next[1]);
			if (nextStart < start + playTime) {
				stack.add(new Project(p[0], playTime - (nextStart - start)));
			} else {
				answer[cnt++] = p[0];
				if (start + playTime < nextStart && !stack.isEmpty()) {
					int remain = nextStart - (start + playTime);
					while (!stack.isEmpty() && remain > 0) {
						Project project = stack.pop();
						if (project.remain <= remain) {
							answer[cnt++] = project.name;
							remain -= project.remain;
						} else {
							project.remain -= remain;
							stack.add(project);
							break;
						}
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			answer[cnt++] = stack.pop().name;
		}

		return answer;
	}

	static public int timeToInt(String time) {
		String[] times = time.split(":");
		return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
	}

	static class MySort implements Comparator<String[]> {

		@Override
		public int compare(String[] o1, String[] o2) {

			return timeToInt(o1[1]) - timeToInt(o2[1]);
		}

	}

}

class Project {
	String name;
	int remain;

	Project(String name, int remain) {
		this.name = name;
		this.remain = remain;
	}
}

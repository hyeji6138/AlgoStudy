package level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러 {
	public static void main(String[] args) {
		int[][] jobs = { { 24, 10 }, { 28, 39 }, { 43, 20 }, { 37, 5 }, { 47, 22 }, { 20, 47 }, { 15, 34 }, { 15, 2 },
				{ 35, 43 }, { 26, 1 } };
		System.out.println(solution(jobs));
	}

	public static int solution(int[][] jobs) {
		int answer = 0;
		int time = 0;
		// 들어온 순서대로 정렬
		PriorityQueue<int[]> pq1 = new PriorityQueue<int[]>(new MyComparator1());
		for (int i = 0; i < jobs.length; i++) {
			pq1.add(jobs[i]);
		}

		PriorityQueue<int[]> pq2 = new PriorityQueue<int[]>(new MyComparator2());
		int sum = 0;
		while (!pq1.isEmpty()) {
			while (!pq1.isEmpty() && pq1.peek()[0] <= time) {
				pq2.add(pq1.poll());
			}

			if (!pq1.isEmpty() && pq2.isEmpty()) {
				int[] job = pq1.poll();
				pq2.add(job);
				time = job[0];
			}

			int[] job = pq2.poll();
			sum += (time + job[1] - job[0]);
			time += job[1];
		}
		while (!pq2.isEmpty()) {
			int[] job = pq2.poll();
			sum += (time + job[1] - job[0]);
			time += job[1];
		}

		answer = sum / jobs.length;
		return answer;
	}

	static class MyComparator1 implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		}

	}

	static class MyComparator2 implements Comparator<int[]> {

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			return o1[1] - o2[1];
		}

	}

}

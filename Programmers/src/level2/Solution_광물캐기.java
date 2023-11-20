package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_광물캐기 {
	public static void main(String[] args) {
		int[] picks = { 0, 1, 1 };
		String[] minerals = { "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron",
				"iron", "diamond" };
		System.out.println(solution(picks, minerals));
	}

	static public int solution(int[] picks, String[] minerals) {
		int answer = Integer.MAX_VALUE;
		Queue<Mining> queue = new LinkedList<>();
		queue.add(new Mining(0, picks[0], picks[1], picks[2], 0));
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int s = 0; s < size; s++) {
				Mining m = queue.poll();
				if (m.step < minerals.length) {
					if (m.dPickCnt + m.iPickCnt + m.sPickCnt == 0) {
						answer = Math.min(answer, m.fatigue);
					} else {
						if (m.dPickCnt > 0) {
							int sum = 0;
							for (int i = 0; i < 5 && m.step + i < minerals.length; i++) {
								sum += play(minerals[m.step + i], 0);
							}
							queue.add(new Mining(m.step + 5, m.dPickCnt - 1, m.iPickCnt, m.sPickCnt, m.fatigue + sum));
						}
						if (m.iPickCnt > 0) {
							int sum = 0;
							for (int i = 0; i < 5 && m.step + i < minerals.length; i++) {
								sum += play(minerals[m.step + i], 1);
							}
							queue.add(new Mining(m.step + 5, m.dPickCnt, m.iPickCnt - 1, m.sPickCnt, m.fatigue + sum));
						}
						if (m.sPickCnt > 0) {
							int sum = 0;
							for (int i = 0; i < 5 && m.step + i < minerals.length; i++) {
								sum += play(minerals[m.step + i], 2);
							}
							queue.add(new Mining(m.step + 5, m.dPickCnt, m.iPickCnt, m.sPickCnt - 1, m.fatigue + sum));
						}
					}
				} else {
					answer = Math.min(answer, m.fatigue);
				}
			}
		}
		return answer;
	}

	static public int play(String mineral, int pick) {
		int[][] fatigues = { { 1, 1, 1 }, { 5, 1, 1 }, { 25, 5, 1 } };
		if (mineral.equals("diamond")) {
			return fatigues[pick][0];
		} else if (mineral.equals("iron")) {
			return fatigues[pick][1];
		} else {
			return fatigues[pick][2];
		}
	}

	static class Mining {
		int dPickCnt, iPickCnt, sPickCnt;
		int step, fatigue;

		Mining(int step, int dPickCnt, int iPickCnt, int sPickCnt, int fatigue) {
			this.step = step;
			this.dPickCnt = dPickCnt;
			this.iPickCnt = iPickCnt;
			this.sPickCnt = sPickCnt;
			this.fatigue = fatigue;
		}
	}
}

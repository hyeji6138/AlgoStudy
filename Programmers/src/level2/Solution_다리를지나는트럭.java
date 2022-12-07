package level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_다리를지나는트럭 {
	public static void main(String[] args) {
		int bridge_length = 100;
		int weight = 100;
		int[] truct_weights = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		System.out.println(solution(bridge_length, weight, truct_weights));
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		Queue<Truck> bridge = new LinkedList<>();
		int bridge_weight = 0, idx = 0;
		while (!bridge.isEmpty() || idx < truck_weights.length) {
			int size = bridge.size();
			for (int s = 0; s < size; s++) {
				Truck t = bridge.poll();
				if (t.time < bridge_length) {
					t.time += 1;
					bridge.add(t);
				} else {
					bridge_weight -= t.weight;
				}
			}
			if (idx < truck_weights.length && bridge_weight + truck_weights[idx] <= weight) {
				bridge.add(new Truck(truck_weights[idx], 1));
				bridge_weight += truck_weights[idx];
				idx++;
			}
			answer++;
		}

		return answer;
	}

	static class Truck {
		int weight;
		int time;

		public Truck(int weight, int time) {
			this.weight = weight;
			this.time = time;
		}
	}

}

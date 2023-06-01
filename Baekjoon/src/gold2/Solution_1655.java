package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution_1655 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (minHeap.isEmpty()) {
				minHeap.add(num);
			} else if (maxHeap.isEmpty()) {
				if (minHeap.peek() > num) {
					maxHeap.add(minHeap.poll());
					minHeap.add(num);
				} else {
					maxHeap.add(num);
				}
			} else if (num > maxHeap.peek()) {
				if (minHeap.size() <= maxHeap.size()) {
					minHeap.add(maxHeap.poll());
				}
				maxHeap.add(num);
			} else if (num < minHeap.peek()) {
				if (minHeap.size() > maxHeap.size()) {
					maxHeap.add(minHeap.poll());
				}
				minHeap.add(num);
			} else {
				if (minHeap.size() > maxHeap.size()) {
					maxHeap.add(num);
				} else {
					minHeap.add(num);
				}
			}
			sb.append(minHeap.peek() + "\n");
		}
		System.out.println(sb.toString());

	}

}

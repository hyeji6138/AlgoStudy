package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution_주차요금계산 {
	public static void main(String[] args) {
		int[] fees = { 1, 461, 1, 10 }; // 기본 시간, 기본 요금, 단위 시간, 단위 요금
		String[] records = { "00:00 1234 IN" };
		System.out.println(Arrays.toString(solution(fees, records)));
	}

	public static int[] solution(int[] fees, String[] records) {
		List<String> cars = new ArrayList<>();
		HashMap<String, Integer> parking = new HashMap<>();
		HashMap<String, Integer> usage = new HashMap<>();
		for (int i = 0; i < records.length; i++) {
			String[] data = records[i].split(" ");
			if (!cars.contains(data[1])) {
				cars.add(data[1]);
			}

			if (!parking.containsKey(data[1])) {
				parking.put(data[1], timeToMinute(data[0])); // 1 = in
			} else {
				int time = parking.remove(data[1]);
				if (!usage.containsKey(data[1])) {
					usage.put(data[1], Math.abs(timeToMinute(data[0]) - time));
				} else {
					usage.replace(data[1], usage.get(data[1]) + Math.abs(timeToMinute(data[0]) - time));
				}
			}
		}
		if (parking.size() > 0) {
			for (String car : parking.keySet()) {
				if (usage.containsKey(car)) {
					usage.replace(car, usage.get(car) + Math.abs(timeToMinute("23:59") - parking.get(car)));
				} else {
					usage.put(car, Math.abs(timeToMinute("23:59") - parking.get(car)));
				}
			}
		}

		int[] answer = new int[cars.size()];
		Collections.sort(cars);
		for (int i = 0; i < cars.size(); i++) {
			int time = usage.get(cars.get(i));
			int add = 0;
			if (time > fees[0]) {
				add = (time - fees[0]) % fees[2] > 0 ? (time - fees[0]) / fees[2] + 1 : (time - fees[0]) / fees[2];
			}
			answer[i] = fees[1] + add * fees[3];
		}

		return answer;
	}

	public static int timeToMinute(String time) {
		int answer = 0;
		String[] times = time.split(":");
		answer = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
		return answer;
	}

}

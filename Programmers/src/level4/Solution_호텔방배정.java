package level4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_호텔방배정 {
	public static void main(String[] args) {
		int k = 10;
		long[] room_number = { 1, 3, 4, 1, 3, 1 };
		System.out.println(Arrays.toString(solution(k, room_number)));
	}

	static public long[] solution(long k, long[] room_number) {
		long[] answer = new long[room_number.length];
		HashMap<Long, Long> hash = new HashMap<>();
		for (int i = 0; i < room_number.length; i++) {
			long num = room_number[i];
			List<Long> list = new ArrayList<Long>();
			while (true) {
				if (!hash.containsKey(num)) {
					answer[i] = num;
					hash.put(num, num + 1);
					for (int j = 0; j < list.size(); j++) {
						hash.replace(list.get(j), num + 1);
					}
					break;
				} else {
					list.add(num);
					num = hash.get(num);
				}
			}
		}
		return answer;
	}

}

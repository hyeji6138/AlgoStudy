package level2;

import java.util.ArrayList;
import java.util.List;

public class Solution_캐시 {
	public static void main(String[] args) {
		int cacheSize = 2;
		String[] cities = { "Jeju", "Pangyo", "NewYork", "newyork" };
		System.out.println(solution(cacheSize, cities));
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;
		List<String> city = new ArrayList<>();
		List<Integer> cnt = new ArrayList<>();
		for (int i = 0; i < cities.length; i++) {
			String key = cities[i].toLowerCase();
			if (city.contains(key)) {
				int idx = city.indexOf(key);
				int temp = cnt.remove(idx);
				city.remove(idx);
				city.add(key);
				cnt.add(temp + 1);
				answer += 1;
			} else {
				if (cacheSize > 0) {
					if (city.size() == cacheSize) {
						city.remove(0);
						cnt.remove(0);
					}
					city.add(key);
					cnt.add(1);
				}
				answer += 5;
			}
		}

		return answer;
	}

}

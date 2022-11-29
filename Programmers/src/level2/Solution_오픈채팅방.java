package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	public static String[] solution(String[] record) {
		List<String[]> system = new ArrayList<>();
		HashMap<String, String> users = new HashMap<>();
		for (int i = 0; i < record.length; i++) {
			String[] data = record[i].split(" ");
			if (data[0].equals("Enter")) {
				if (users.containsKey(data[1])) {
					users.replace(data[1], data[2]);
				} else {
					users.put(data[1], data[2]);
				}
				system.add(new String[] { data[1], "님이 들어왔습니다." });
			} else if (data[0].equals("Change")) {
				users.replace(data[1], data[2]);
			} else {
				system.add(new String[] { data[1], "님이 나갔습니다." });
			}
		}
		String[] answer = new String[system.size()];
		for (int i = 0; i < system.size(); i++) {
			String[] data = system.get(i);
			answer[i] = users.get(data[0]) + data[1];
		}

		return answer;
	}

}

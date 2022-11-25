package level2;

import java.util.HashSet;

public class Solution_전화번호목록 {
	public static void main(String[] args) {
		String[] phone_book = { "12", "123", "1235", "567", "88" };
		System.out.println(solution(phone_book));

	}

	public static boolean solution(String[] phone_book) {
		HashSet<String> hash = new HashSet<>();
		for (int i = 0; i < phone_book.length; i++) {
			hash.add(phone_book[i]);
		}
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 1; j <= phone_book[i].length(); j++) {
				String temp = phone_book[i].substring(0, j);
				if (hash.contains(temp) && !temp.equals(phone_book[i])) {
					return false;
				}
			}
		}
		return true;
	}

}

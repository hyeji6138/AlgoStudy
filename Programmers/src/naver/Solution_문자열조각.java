package naver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 2021.07.04 네이버웹툰 개발 챌린지 1차 코딩 테스트 (Back-End) 2번*/
public class Solution_문자열조각 {
	public static void main(String[] args) {
		// abcxyasdfasdfxyabc, abcxyqwertyxyabc, abcabcabcabc, llttaattll, zzzzzz, abcdef
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<500000;i++) {
			sb.append("a");
		}
		for(int j=0;j<500000;j++) {
			sb.append("b");
		}
//		System.out.println(Arrays.toString(solution_01(sb.toString())));
		System.out.println(Arrays.toString(solution_02(sb.toString())));
	}
	
	public static String[] solution_02(String s) {
		String[] answer = {};
		String temp = s;
		int eIdx = temp.length()-1, idx = 0;
		List<String> list = new ArrayList<String>();
		
		while(eIdx >= temp.length()/2) {
			if(temp.charAt(0) == temp.charAt(eIdx)) {
				if(temp.substring(0, temp.length()-eIdx).equals(temp.substring(eIdx))) {
					list.add(idx, temp.substring(eIdx));
					list.add(idx, temp.substring(eIdx));
					idx++;
					temp = temp.substring(temp.length()-eIdx, eIdx);
					eIdx = temp.length()-1;
				}
			}else {
				eIdx--;
			}
		}
		if(temp.length() > 0 ) list.add(idx, temp);
		
		answer = new String[list.size()];
		
		for(int i=0;i<list.size();i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

	public static String[] solution_01(String s) {
		String[] answer = {};
		int size = 1, idx = 0;
		String temp = s;
		List<String> list = new ArrayList<String>();

		while (size <= temp.length() / 2) {
			String str1 = temp.substring(0, size);
			String str2 = temp.substring(temp.length() - size);
			
			if (str1.equals(str2)) {
				list.add(idx, str1);
				list.add(idx, str2);
				temp = temp.substring(size, temp.length() - size);
				size = 1;
				idx++;
			} else {
				size++;
			}
		}

		if (temp.length() > 0) list.add(idx, temp);
		answer = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}

}

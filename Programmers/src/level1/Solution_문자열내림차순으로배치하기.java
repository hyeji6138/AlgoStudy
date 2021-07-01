package level1;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_문자열내림차순으로배치하기 {
	public static void main(String[] args) {
		System.out.println(solution("AGbcdefg"));
	}
	public static String solution(String s) {
        String answer = "";
        String[] alpha = s.split("");
        
        Arrays.sort(alpha, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
		});
        StringBuffer sb = new StringBuffer();
        for(String a:alpha) {
        	sb.append(a);
        }
        answer = sb.toString();
        return answer;
    }
}

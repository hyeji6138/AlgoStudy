package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_5430 { //AC
	static int T, N;
	static char[] P;
	static Deque<Integer> dq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dq = new ArrayDeque<>();
		StringBuffer sb = new StringBuffer();
		for(int tc=0;tc<T;tc++) {
			P = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			String[] array = br.readLine().replace("[", "").replace("]", "").split(",");
			for(String num : array) {
				if(num.equals("")) break;
				dq.add(Integer.parseInt(num));
			}
			boolean reverse = false;
			boolean error = false;
			for(int i=0;i<P.length;i++) {
				if(P[i] == 'R') { // reverse
					reverse = !reverse;
				}else { // delete
					if(dq.size() < 1) {
						error = true;
						break;
					}
					if(reverse) {
						dq.pollLast();						
					}else {
						dq.pollFirst();
					}
				}
			}
			if(error) {
				sb.append("error");
			}else {
				sb.append("[");
				while(!dq.isEmpty()) {
					if(reverse) sb.append(dq.pollLast());
					else sb.append(dq.pollFirst());
					
					if(dq.size() > 0) sb.append(",");
				}
				sb.append("]");
			}
			sb.append("\n");
			dq.clear();
		}
		System.out.println(sb.toString());
	}

}

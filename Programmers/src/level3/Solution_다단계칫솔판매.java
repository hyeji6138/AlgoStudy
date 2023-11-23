package level3;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_다단계칫솔판매 {
	static int[] result;
	static HashMap<String, Integer> enrollNum;
	static HashMap<String, String> referralLink;

	public static void main(String[] args) {
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int[] amount = { 12, 4, 2, 5, 10 };
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}

	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		result = new int[enroll.length + 1];
		enrollNum = new HashMap<String, Integer>();
		referralLink = new HashMap<String, String>();
		enrollNum.put("-", 0);
		for (int i = 0; i < enroll.length; i++) {
			enrollNum.put(enroll[i], i + 1);
			referralLink.put(enroll[i], referral[i]);
		}
		for (int i = 0; i < seller.length; i++) {
			addAmount(seller[i], amount[i] * 100);
		}
		for (int i = 1; i < result.length; i++) {
			answer[i - 1] = result[i];
		}
		return answer;
	}

	static public void addAmount(String enroll, int sell) {
		if (enrollNum.get(enroll) == 0) {
			return;
		}
		int tenPer = sell / 10;
		result[enrollNum.get(enroll)] += sell - tenPer;
		addProfit(referralLink.get(enroll), tenPer);
	}

	static public void addProfit(String enroll, int profit) {
		if (enrollNum.get(enroll) == 0) {
			return;
		}
		if (profit < 10) {
			result[enrollNum.get(enroll)] += profit;
		} else {
			int tenPer = profit / 10;
			result[enrollNum.get(enroll)] += profit - tenPer;
			addProfit(referralLink.get(enroll), tenPer);
		}
	}
}

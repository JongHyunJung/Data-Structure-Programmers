package Programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution12 {
	public int[] mysolution(int[] prices) {
		Queue<Integer> answer = new LinkedList<>();
		
		for(int i=0 ; i<prices.length ; i++) {
			int num = 0;
			for(int j=i+1 ; j<prices.length ; j++) {
				num ++;
				if(prices[j] < prices[i]) {
					break;
				}
			}
			answer.offer(num);
		}
		
		return answer.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		for(int i=0 ; i<prices.length ; i++) {
			int price = prices[i];
			int seconds = 0;
			for(int j=i+1 ; j<prices.length ; j++) {
				seconds++;
				if(price > prices[j]) break;
			}
			answer[i] = seconds;
		}
		
		return answer;
	}
}

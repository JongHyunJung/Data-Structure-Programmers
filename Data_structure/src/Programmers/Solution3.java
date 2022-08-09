package Programmers;
import java.util.*;
/*
문제 설명
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

제한 조건
n은 10,000,000,000이하인 자연수입니다.
 */

public class Solution3 {
	public ArrayList<Long> mysolution(long n) {
        long temp = n;
        int cnt = 0;
        
        // n 자릿수 계산
        while(true){
            temp = temp/10;
            cnt ++;
            if(temp == 0) break;
        }
        
        ArrayList<Long> list = new ArrayList<>(cnt);
        
        // 역순으로 리스트에 삽입 
        for(int i=0 ; i<cnt ; i++){
            list.add(n%10);
            n = n/10;
        }
        
        return (list);
    }
	
	public int[] solution(long n) {
		List<Integer> list = new LinkedList<>();
		
		while(n > 0) {
			list.add((int)(n%10));
			n /= 10;
		}
		
		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}

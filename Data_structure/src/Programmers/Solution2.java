package Programmers;
import java.util.*;
/*
문제 설명
길이가 n인 배열에 1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는지를 확인하려고 합니다.
1부터 n까지 숫자가 중복 없이 한 번씩 들어 있는 경우 true를, 아닌 경우 false를 반환하도록 함수 solution을 완성해주세요.

제한사항
배열의 길이는 10만 이하입니다.
배열의 원소는 0 이상 10만 이하인 정수입니다.
*/
public class Solution2 {
	public boolean mysolution(int[] arr) {
        boolean answer = true;
        int maxNum = arr.length;
        int[] temp = new int[maxNum];
        int num = 0;
        
        for(int i=1 ; i<=arr.length ; i++){
            for(int j=0 ; j<maxNum ; j++){        
                if(arr[j] > maxNum){
                    answer = false;
                    return answer;
                } else if(arr[j] == i){
                    if(temp[num] == arr[j]){
                        answer = false;
                        return answer;
                    }
                    temp[num] = i;
                }         
            }
            num++;
        }

        return answer;
    }
	/*채점 결과
	정확성: 70.3
	효율성: 11.1
	합계: 81.4 / 100.0
	 */
	
	public boolean slow_solution(int[] arr) {
		//시간 복잡도 -> O(n^2)
		for(int i=0 ; i<arr.length ; i++) {
			int found = 0;
			for(int a : arr) {
				if(a == i) found++;
			}
			if(found != 1) return false;
		}
		return true;
	}
	
	public boolean fast_solution(int[] arr) {
		//전체 시간복잡도 -> O(nlogn)
		Arrays.sort(arr); // sort의 시간복잡도 -> O(nlogn)
	        
		// for문 시간 복잡도 -> O(n)
	    for(int i=0 ; i<arr.length ; i++){
	        if(arr[i] != i+1) return false;
	    }
	    
	    return true;
	}
}

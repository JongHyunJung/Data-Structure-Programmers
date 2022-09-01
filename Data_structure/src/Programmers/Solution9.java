package Programmers;
import java.util.*;

/*
문제 설명
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
 */

public class Solution9 {
	public List<Integer> mysolution(int[] arr) {
		int[] answer = arr;
		int k = 0;
		List<Integer> num = new LinkedList<Integer>();
		
		num.add(arr[0]);
		
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[k] != answer[i]) num.add(answer[i]);
			k++;
		}
		
		return num;
	}
	
	public int[] solution1(int[] arr){
		List<Integer> num = new LinkedList<>();
		int last = -1;	
		
		for(int a : arr) {
			if(a == last) continue;
			last = a; 
			num.add(a);
		}
		
		return num.stream().mapToInt(Integer::intValue).toArray();
		 
	}
}

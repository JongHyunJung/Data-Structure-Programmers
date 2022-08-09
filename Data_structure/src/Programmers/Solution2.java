package Programmers;
import java.util.*;
/*
���� ����
���̰� n�� �迭�� 1���� n���� ���ڰ� �ߺ� ���� �� ���� ��� �ִ����� Ȯ���Ϸ��� �մϴ�.
1���� n���� ���ڰ� �ߺ� ���� �� ���� ��� �ִ� ��� true��, �ƴ� ��� false�� ��ȯ�ϵ��� �Լ� solution�� �ϼ����ּ���.

���ѻ���
�迭�� ���̴� 10�� �����Դϴ�.
�迭�� ���Ҵ� 0 �̻� 10�� ������ �����Դϴ�.
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
	/*ä�� ���
	��Ȯ��: 70.3
	ȿ����: 11.1
	�հ�: 81.4 / 100.0
	 */
	
	public boolean slow_solution(int[] arr) {
		//�ð� ���⵵ -> O(n^2)
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
		//��ü �ð����⵵ -> O(nlogn)
		Arrays.sort(arr); // sort�� �ð����⵵ -> O(nlogn)
	        
		// for�� �ð� ���⵵ -> O(n)
	    for(int i=0 ; i<arr.length ; i++){
	        if(arr[i] != i+1) return false;
	    }
	    
	    return true;
	}
}

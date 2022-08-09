package Programmers;
import java.util.*;
/*
���� ����
�ڿ��� n�� ������ �� �ڸ� ���ڸ� ���ҷ� ������ �迭 ���·� �������ּ���. ������� n�� 12345�̸� [5,4,3,2,1]�� �����մϴ�.

���� ����
n�� 10,000,000,000������ �ڿ����Դϴ�.
 */

public class Solution3 {
	public ArrayList<Long> mysolution(long n) {
        long temp = n;
        int cnt = 0;
        
        // n �ڸ��� ���
        while(true){
            temp = temp/10;
            cnt ++;
            if(temp == 0) break;
        }
        
        ArrayList<Long> list = new ArrayList<>(cnt);
        
        // �������� ����Ʈ�� ���� 
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

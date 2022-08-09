package Programmers;
import java.util.*;
import java.util.stream.IntStream;
/*
�־��� �Է��� �ִ밪�� ���ϰ�, �ִ밪�� �� ��ġ�ϴ� index ���� ����� ��ȯ�ϼ���.

�Է�:
[1, 3, 5, 4, 5, 2, 1]

�Էµ� ����� �ִ밪�� 5�Դϴ�.
5�� ������ ���� ���� ��ġ�� 3��°, 5��° ��ġ �Դϴ�.
�� ��ġ�� �ش��ϴ� index�� [2, 4] �Դϴ�.

���:
[2, 4]
*/

public class Solution1 {
	public int[] mysolution(int[] arr) {
        int max = 0, cnt = 0, temp = 0;
        
        //�ִ� ���ϱ�
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] > max) max = arr[i];
        }
        
        //�ִ� ���� ���ϱ�
        for(int j=0 ; j<arr.length ; j++){
            if(arr[j] == max) cnt ++;
        }
        
        //�ִ� ������ answer �迭 ����
        int[] answer = new int[cnt];
        
        //�ִ񰪰� ���� index�� ���� 
        for(int k=0 ; k<arr.length ; k++){
            if(arr[k] == max) {
                answer[temp] = k;
                temp ++;
            }
        }
        
        return answer;
    }
	
	public int[] array_solution(int[] arr) {
		// �ִ밪 ���ϱ�
		int max = 0;
		// �ִ밪 ����� Ȯ���ϱ�
		int count = 0;
		for(int a : arr) if(a == max) count++;
		// �迭�����
		int[] answer = new int[count];
		// �迭�� �ε��� ä���
		int index = 0;
 		for(int i=0 ; i<arr.length ; i++) {
 			if(arr[i] == max) answer[index++] = i;
 		}
		return answer;
	}
	
	public int[] list_solution(int[] arr) {
		// �ִ밪 ���ϱ�
		int max = 0;
		
		// ����Ʈ �����
		List<Integer> list = new LinkedList<>();
		
		// �迭�� �ε��� ä���
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] == max) list.add(i);
		}
		
		// ����Ʈ�� �迭�� ��ȯ
		//return list.stream().mapToInt(Integer::intValue).toArray();
		int answer[] = new int[list.size()];
		for(int i=0 ; i<list.size() ; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
	
	public int[] stream_solution(int[] arr) {
		int max = Arrays.stream(arr).max().getAsInt();
		
		return IntStream.range(0, arr.length)
			.filter(i->arr[i] == max)
			.toArray();
	}
}

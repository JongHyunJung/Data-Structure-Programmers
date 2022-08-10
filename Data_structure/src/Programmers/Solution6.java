package Programmers;
import java.util.*;
/*
���� ����
�����̵��� ���� �ٸ� ���� �����Ͽ� �Ծ� �ڽ��� �����մϴ�.

���� ��� �����̰� ���� ���� �Ʒ��� ���� ���� �����̰� ���׶� �Ȱ�, �� ��Ʈ, �Ķ��� Ƽ������ �Ծ��ٸ� �������� û������ �߰��� �԰ų� ���׶� �Ȱ� ��� ���� ���۶󽺸� �����ϰų� �ؾ� �մϴ�.

����	�̸�
��	���׶� �Ȱ�, ���� ���۶�
����	�Ķ��� Ƽ����
����	û����
�ѿ�	�� ��Ʈ
�����̰� ���� �ǻ���� ��� 2���� �迭 clothes�� �־��� �� ���� �ٸ� ���� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
clothes�� �� ���� [�ǻ��� �̸�, �ǻ��� ����]�� �̷���� �ֽ��ϴ�.
�����̰� ���� �ǻ��� ���� 1�� �̻� 30�� �����Դϴ�.
���� �̸��� ���� �ǻ��� �������� �ʽ��ϴ�.
clothes�� ��� ���Ҵ� ���ڿ��� �̷���� �ֽ��ϴ�.
��� ���ڿ��� ���̴� 1 �̻� 20 ������ �ڿ����̰� ���ĺ� �ҹ��� �Ǵ� '_' �θ� �̷���� �ֽ��ϴ�.
�����̴� �Ϸ翡 �ּ� �� ���� �ǻ��� �Խ��ϴ�.
 */
public class Solution6 {
	//[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]
	// headgear : 2 -> 3
	// eyewear : 1 -> 2
	// 3 * 2 = 6 -1(������ ��� ���� ��츦 ��)
	public int map_solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> spy = new HashMap<>();
		
		//���� ���� ���� 
		for(String[] clothe : clothes) {
			String type = clothe[1];
			spy.put(type, spy.getOrDefault(type, 0)+1);
		}
		
		//�� ������ �� ���
		for(String key : spy.keySet()) {
			answer *= (spy.get(key) +1);
		}
		
		//���� ��� ���� ��� -1
		return answer-1;
	}
	
	
	public int iterator_solution(String[][] clothes) {
		int answer = 1;
		
		Map<String, Integer> spy = new Hashtable<>();
		
		for(String[] clothe : clothes) {
			String type = clothe[1];
			spy.put(type, spy.getOrDefault(type, 0)+1);
		}
		
		var iter = spy.values().iterator();
		while(iter.hasNext()) {
			answer *= iter.next() + 1; 
		}
		
		return answer - 1; 
	}
}

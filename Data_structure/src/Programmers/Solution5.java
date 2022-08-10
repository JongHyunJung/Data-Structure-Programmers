package Programmers;
import java.util.*;

/*
���� ����
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.

�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, �������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

���ѻ���
������ ��⿡ ������ ������ ���� 1�� �̻� 100,000�� �����Դϴ�.
completion�� ���̴� participant�� ���̺��� 1 �۽��ϴ�.
�������� �̸��� 1�� �̻� 20�� ������ ���ĺ� �ҹ��ڷ� �̷���� �ֽ��ϴ�.
������ �߿��� ���������� ���� �� �ֽ��ϴ�.
*/

public class Solution5 {
	public String list_solution(String[] participant, String[] completion) {
		List<String> players = new LinkedList<>();
		
		for(String p : participant) players.add(p);
		for(String c : completion) players.remove(c); //<<- �ð��� ���� �����ɸ�
		
		return players.get(0);
	}
	
	//��ü �ð����⵵ O(n)
	public String map_solution(String[] participant, String[] completion) {
		Map<String, Integer> marathon = new Hashtable<>();
		
		//O(n)
		for(String player : participant) {
			marathon.put(player, marathon.getOrDefault(player, 0) + 1);
		}
		
		//O(n)
		for(String player : completion) {
			int value = marathon.get(player) -1;
			if(value == 0) marathon.remove(player);
			else marathon.put(player, value);
		}
		
		
		return marathon.keySet().iterator().next();
	}
	
	//��ü �ð����⵵ O(nlogn)
	public String solution(String[] participant, String[] completion) {
		Arrays.sort(participant); //O(nlogn)
		Arrays.sort(completion); //O(nlogn)
		
		//O(n)
		for(int i=0 ; i<completion.length ; i++) {
			if(!participant[i].equals(completion[i])) return participant[i];
		}
		
		return participant[participant.length-1];
	}
}

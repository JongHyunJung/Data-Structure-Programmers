package Programmers;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
문제 설명
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 
이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 
현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
 */
public class Solution13 {
	public int mysolution(int[] priorities, int location) {
		int answer = 0, flag = 0;
		flag = priorities[location];
		Deque<Integer> printer = new LinkedList<>();
		
		for(int n : priorities) {
			printer.offer(n);
		}
		
		for(int i=0 ; i<priorities.length ; i++) {
			if(i == location) answer++;
			for(int j=i+1 ; j<priorities.length ; j++) {
				if(priorities[i] < priorities[j]) {
					printer.pollFirst();
					printer.offerLast(priorities[i]);
					break;
				}
			}
		}
		
		
		int num = 0;
		for(int m : printer) {
			num ++;
			if(m == flag) { 
				answer = num;
				break;
			}
		}
		
		return answer;
	}
	
	
	class Paper {
		boolean isMine;
		int prioriy;
		Paper(int p, boolean m){
			this.prioriy = p;
			this.isMine = m;
		}
	}
	
	public int solution(int[] priorities, int location) {
		List<Paper> queue = new LinkedList<>();
		for(int i=0 ; i<priorities.length ; i++) {
			queue.add(new Paper(priorities[i], i == location));
		}
		
		int answer = 0;
		while(!queue.isEmpty()) {
			Paper now = queue.remove(0);
			
			boolean printable = true;
			for(Paper p : queue){
				if(now.prioriy < p.prioriy) {
					printable = false;
					break;
				}
			}
			if(!printable) {
				queue.add(now);
				continue;
			}
			
			answer++;
			if(now.isMine) return answer;
		}
		
		return answer;
		
		// [2, 1, (3), 2]
		// (3), [2, 2, 1] : 1번째 출력 => 1
		// [(1), 1, 9, 1, 1, 1]
		// 9 [1, 1, 1, (1), 1] : 1번째 출력
		// 1 [1, 1, (1), 1] : 2번째 출력
		// 1 [1, (1), 1] : 3번째 출력
		// 1 [(1), 1] : 4번째 출력
		// (1) [1] : 5번째 출력 => 5
	}
}

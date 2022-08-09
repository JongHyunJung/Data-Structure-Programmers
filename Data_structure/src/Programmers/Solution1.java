package Programmers;
import java.util.*;
import java.util.stream.IntStream;
/*
주어진 입력중 최대값을 구하고, 최대값이 이 위치하는 index 값의 목록을 반환하세요.

입력:
[1, 3, 5, 4, 5, 2, 1]

입력된 목록의 최대값은 5입니다.
5와 동일한 값을 가진 위치는 3번째, 5번째 위치 입니다.
이 위치에 해당하는 index는 [2, 4] 입니다.

출력:
[2, 4]
*/

public class Solution1 {
	public int[] mysolution(int[] arr) {
        int max = 0, cnt = 0, temp = 0;
        
        //최댓값 구하기
        for(int i=0 ; i<arr.length ; i++){
            if(arr[i] > max) max = arr[i];
        }
        
        //최댓값 갯수 구하기
        for(int j=0 ; j<arr.length ; j++){
            if(arr[j] == max) cnt ++;
        }
        
        //최댓값 갯수로 answer 배열 생성
        int[] answer = new int[cnt];
        
        //최댓값과 같은 index값 저장 
        for(int k=0 ; k<arr.length ; k++){
            if(arr[k] == max) {
                answer[temp] = k;
                temp ++;
            }
        }
        
        return answer;
    }
	
	public int[] array_solution(int[] arr) {
		// 최대값 구하기
		int max = 0;
		// 최대값 몇개인지 확인하기
		int count = 0;
		for(int a : arr) if(a == max) count++;
		// 배열만들기
		int[] answer = new int[count];
		// 배열에 인덱스 채우기
		int index = 0;
 		for(int i=0 ; i<arr.length ; i++) {
 			if(arr[i] == max) answer[index++] = i;
 		}
		return answer;
	}
	
	public int[] list_solution(int[] arr) {
		// 최대값 구하기
		int max = 0;
		
		// 리스트 만들기
		List<Integer> list = new LinkedList<>();
		
		// 배열에 인덱스 채우기
		for(int i=0 ; i<arr.length ; i++) {
			if(arr[i] == max) list.add(i);
		}
		
		// 리스트를 배열로 변환
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

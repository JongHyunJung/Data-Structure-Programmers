package Programmers;

import java.util.*;

/*
문제 설명
로또복권의 번호는 1에서 45 사이의 값을 가진 6개의 숫자로 구성됩니다.
로또복권을 신청하는 사용자들은 OMR카드에 숫자를 마킹하여 신청을 하는데, 가끔 잘못 표시하여 신청하는 사용자들이 있습니다.
로또복권에 등록 가능한 숫자조합인지 확인하는 기능을 작성해 주세요

입력1: [4, 7, 32, 43, 22, 19]
출력1: true

6개의 숫자가 중복없이 1~45사이의 값을 가지고 로또복권 등록이 가능합니다.

입력2: [3, 19, 34, 39, 39, 20]
출력2: false

6개의 숫자 중 39가 중복되어 로또복권 등록이 불가능합니다.

 */

public class Solution7 {
	public boolean mysolution(int[] lotto) {
		boolean answer = true;
		
		Set<Integer> number = new LinkedHashSet<Integer>();
		
		for(int n : lotto) {
			number.add(n);
		}
		
		if(number.size() != 6) answer = false;
		
		return answer;
	}
	
	public boolean solution1(int[] lotto) {
		boolean[] checker = new boolean[45+1];
		for(int l : lotto) {
			if(l<1 || l>45) return false;
			if(checker[l]) return false;
			checker[l] = true;
		}
		return true;
	}
	
	public boolean solution2(int[] lotto) {
		Set<Integer> number = new HashSet<>();
		
		for(int l : lotto) {
			if(l<1 || l>45) return false;
			number.add(l);
		}
		return number.size() == lotto.length;
		
	}
}

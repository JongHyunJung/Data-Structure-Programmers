package Programmers;

/* 
문제설명

괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어

"()()" 또는 "(())()" 는 올바른 괄호입니다.
")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
'(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.

제한사항
문자열 s의 길이 : 100,000 이하의 자연수
문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution10 {
	boolean mysolution(String s) {
		//Deque<String> bracket = new LinkedList<>();
		char lb = '(', rb = ')';
		int lnum = 0, rnum = 0;
		
		if(s.charAt(0) != lb || s.charAt(s.length()-1) != rb) {
			return false;
		}
		
		for(int i=1 ; i<s.length() ; i++) {
			if(s.charAt(i) == lb) {
				lnum++;
			} else if(s.charAt(i) == rb) {
				rnum++;
			}
		}
		
		if((lnum+rnum)%2 == 0 && lnum == rnum) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean mysolution2(String s) {
		Deque<Character> bracket = new LinkedList<>();
		int lb = 0, rb = 0;
		
		if(s.charAt(0) == ')' || s.charAt(s.length() -1) == '(') return false;
		
		for(int i=0 ; i<s.length() ; i++) {
			bracket.offer(s.charAt(i));
		}
		
		for(int j=0 ; j<s.length() ; j++) {
			if(s.charAt(j) == '(') {
				bracket.pollFirst(); 
				lb ++;
			} else if(s.charAt(j) == ')') {
				bracket.pollFirst();
				rb++;
			} else {
				return false;
			}
		}
		
		if((rb+lb)%2 == 0 && lb == rb) return true;
		
		return false;
	}
	
	boolean myStacksolution(String s) {
		Deque<Character> bracket = new LinkedList<>();
        //if(s.charAt(0) == ')' || s.charAt(s.length() -1) == '(') return false;
        
		for(int i=0 ; i<s.length() ; i++) {
			if(s.charAt(i) == '(') {
				bracket.offer(s.charAt(i));
			} else {
				if(bracket.size() == 0) return false;
                bracket.poll();
			}
        }
        
        if(bracket.size() != 0) {
            return false;
        } else {
            return true;
        }
	}
	
	boolean solution1(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == '(') stack.push(c);
			else {
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
		return stack.isEmpty() == true;
	}
	
	boolean solution2(String s) {
		int stack = 0;
		for(char c : s.toCharArray()) {
			if(c ==  '(') stack++;
			else {
				if(stack == 0) return false;
				stack--;
			}
		}
		return stack == 0;
	}
}

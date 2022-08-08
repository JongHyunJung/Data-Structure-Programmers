package Programmers;

//시간 복잡도
public class Lecture1_3 {
	
	//O(1)
	public int func1(int[] n) {
		if (n.length < 3) {
			return 0;
		}
		
		int a = n[0];
		a += n[1];
		a += n[2];
		
		return a;
	}
	
	//O(n)
	public int sum1(int[] n) {
		int s = 0;
		
		for (int i : n) {
			s += i;
		}
		
		return s;
	}
	
	//O(n^2)
	public void bubbleSort(int[] n) {
		for(int i=0 ; i<n.length ; i++) {
			for(int j=0 ; j<n.length ; j++) {
				if(n[i] < n[j]) {
					int temp = n[j];
					n[j] = n[i];
					n[i] = temp;
				}
			}
		}
	}
	
	//O(logn)
	public int sum2(int[] n) {
		int sum = 0;
		int max = n.length;
		
		while(max > 0) {
			sum += n[max-1];
			max /=2;
		}
		return sum;
	}
	
	//O(?)
	public int sum3(int[] n) {
		int s = 0;
		for(int i:n) {
			s += i;
			for(int j=0 ; j<10 ; j++) {
				s += j;
			}
		}
		return s;
	}
}

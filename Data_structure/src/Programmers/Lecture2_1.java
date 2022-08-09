package Programmers;

import java.util.Arrays;

//Array Ư¡
public class Lecture2_1 {

	public static void main(String[] args) {
		int[] arr = new int[5];
		String[] strs = new String[5];
		boolean[] bools = new boolean[5];
		
		arr[0] = 1;
		arr[4] = 5;
		arr[arr.length - 1] = 5;
		
		System.out.println(Arrays.toString(arr));
		System.out.println(arr[0]);
		System.out.println(arr.length);
		
		System.out.println(Arrays.toString(strs));
		System.out.println(Arrays.toString(bools));
	}

}

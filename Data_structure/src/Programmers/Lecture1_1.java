package Programmers;

//CALL BY VALUE
public class Lecture1_1 {
	static void method (int v) {
		v = v*2;
	}
	
	public static void main(String[] args) {
		int v = 42;
		System.out.println(v);
		method(v);
		System.out.println(v);
		

	}
}

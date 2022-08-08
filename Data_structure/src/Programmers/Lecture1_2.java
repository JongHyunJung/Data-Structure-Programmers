package Programmers;

//CALL BY REFERENCE
public class Lecture1_2 {

	public static void main(String[] args) {
		Data v = new Data();
		v.d = 42;
		System.out.println(v.d);
		method(v);
		System.out.println(v.d);
	}
	
	public static void method(Data v) {
		v.d = v.d * 2;
	}

}

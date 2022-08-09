package Programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

// LinkedList
// List 인터페이스
// ArrayList (not Synch) i don't care about thread-safe, use this. -> 인덱스 빠르게 접근할때 효율적
// Vector (Synch) thread-safe 

class MyData {
	int value;
	
	public MyData(int value) {
		this.value = value;
	}
	
	static MyData create(int v) {
		return new MyData(v);
	}
	
	@Override
	public String toString() {
		return ""+value;
 	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		MyData myData = (MyData) o;
		return value == myData.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}

public class Lecture2_2 {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<MyData> list2 = new LinkedList<>();
		List<MyData> list3 = new Vector<>();
		List<MyData> list4 = new ArrayList<>(10);
 		
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.add(1, 5);
		list.remove(2);
		
		list2.add(MyData.create(1));
		list2.add(MyData.create(2));
		list2.add(MyData.create(3));
		
		list3.add(MyData.create(1));
		list3.add(MyData.create(2));
		list3.add(MyData.create(3));
		
		list4.add(MyData.create(1));
		list4.add(MyData.create(2));
		list4.add(MyData.create(3));
		
		System.out.println(list);
		System.out.println(list.get(2));
		System.out.println(list.contains(6));
		System.out.println(list.contains(Integer.valueOf(6)));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		
		System.out.println();
		System.out.println(list2);
		System.out.println(list2.contains(MyData.create(2)));
		System.out.println(list2.indexOf(MyData.create(3)));
		
		System.out.println();
		method1(list3);
		
		System.out.println();
		method1(list4);
	}
	
	static void method1(List<MyData> list) {
		System.out.println(list.size());
		System.out.println(list.get(2));
		System.out.println(list.isEmpty());
	}

}

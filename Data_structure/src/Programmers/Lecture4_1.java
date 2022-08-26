package Programmers;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class SetData{
	int v;
	
	public SetData(int v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return "" + v;
 	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		SetData setData = (SetData) o;
		return v == setData.v;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(v);
	}
}


class Lecture4_1 {
	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		HashSet<Integer> list2 = new HashSet<Integer>(); //LinkedHashSet으로도 가능
		HashSet<SetData> list3 = new HashSet<SetData>(); // Set은 순서를 보장하지 않는다. Only 중복 여부
		HashSet<SetData> list4 = new LinkedHashSet<SetData>();
		HashSet<SetData> listA = new LinkedHashSet<SetData>();
		HashSet<SetData> listB = new LinkedHashSet<SetData>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		
		if(!list.contains(1)) list.add(1);
		if(!list.contains(2)) list.add(2);
		if(!list.contains(3)) list.add(3);
		
		/*
		list.add(1);
		list.add(2);
		list.add(3);
		*/
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		list3.add(new SetData(1));
		list3.add(new SetData(2));
		list3.add(new SetData(3));
		
		list3.add(new SetData(1));
		list3.add(new SetData(2));
		list3.add(new SetData(3));
		
		//합집합
		list4.add(new SetData(1));
		list4.add(new SetData(2));
		list4.add(new SetData(3));
		
		list4.add(new SetData(2));
		list4.add(new SetData(3));
		list4.add(new SetData(4));
		
		//집합 A
		listA.add(new SetData(1));
		listA.add(new SetData(2));
		listA.add(new SetData(3));
		
		//집합 B
		listB.add(new SetData(2));
		listB.add(new SetData(3));
		listB.add(new SetData(4));
		
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
		
		/*
		//A + B
		listA.addAll(listB);
		System.out.println(listA);
		*/
		
		/*
		//A - B
		listA.removeAll(listB);
		System.out.println(listA);
		*/
		
		//A * B
		listA.retainAll(listB);
		System.out.println(listA);
		
	}
}

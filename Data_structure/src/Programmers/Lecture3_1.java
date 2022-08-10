package Programmers;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentHashMap;
import java.util.HashMap;


// Array 장점 + List 장점 => 유연하면서도 빠르게 값을 찾아낼 수 있는 
// Map : Key => Hash function -> Hash -> bucket index -> List(충돌 해결) -> Data

// Map<K, V>
// HashMap -> not synch : 빠르게 사용하되 thread-safe 필요없을 시 사용
// HashTable -> synch : 멀티스레드 + 싱크 필요시 사용, 병목현상 없이 사용하고 싶다면 ConcurrentHashMap 사용
// ConcurrentHashMap -> synch + high concurrency

class NewData {
	int v;
	public NewData(int v) {
		this.v = v;
	}
	
	@Override
	public String toString() {
		return "[" + v + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		NewData NewData = (NewData) o;
		return v == NewData.v;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(v);
	}
}

public class Lecture3_1 {

	public static void main(String[] args) {
		Hashtable<String, Integer> map = new Hashtable<>();
		Map<String, Integer> map2 = new Hashtable<>();
		Map<String, Integer> map3 = new HashMap<>();
		//Map<String, Integer> maps = new ConcurrentHashMap()<>();
		Map<NewData, Integer> map4 = new ConcurrentHashMap<>();
		
		map4.put(new NewData(1), 1);
		map4.put(new NewData(2), 2);
		map4.replace(new NewData(1), 1, 11);
		
		map3.put("A", 1);
		map3.put("B", 2);
		map3.replace("A", 1, 11);
		//map2.put("A", 10);
		//map2.putIfAbsent("A", 10);
		//map2.remove("B", 2);
		
		map2.put("A", 1);
		map2.put("B", 2);
		map2.replace("A", 1, 11);
		//map2.put("A", 10);
		//map2.putIfAbsent("A", 10);
		//map2.remove("B", 2);
		
		map.put("A", 1);
		map.put("B", 2);
		map.put("A", 3);
		map.put("C", 5);
		map.replace("A", 1, 11);
		//map.put("A", 10);
		//map.putIfAbsent("A", 10);
		//map.remove("B", 2);
		
		method2(map4);
		System.out.println();
		
		method1(map3);
		System.out.println();
		
		method1(map2);
		System.out.println();
		
		System.out.println(map);
		System.out.println(map.get("A"));
		System.out.println(map.get("C"));
		System.out.println(map.getOrDefault("C", -1));
		System.out.println(map.remove("B", 3));
		System.out.println(map.values());
		System.out.println(map.keySet());
	}
	
	static void method1(Map<String, Integer> map2) {
		System.out.println(map2);
		System.out.println(map2.get("A"));
		System.out.println(map2.get("C"));
		System.out.println(map2.getOrDefault("C", -1));
		System.out.println(map2.remove("B", 3));
		System.out.println(map2.values());
		System.out.println(map2.keySet());
	}
	
	static void method2(Map<NewData, Integer> map4) {
		System.out.println(map4.remove(new NewData(2), 2));
		System.out.println(map4);
		System.out.println(map4.get(new NewData(1)));
		System.out.println(map4.getOrDefault(new NewData(1), -1));
		System.out.println(map4.values());
		System.out.println(map4.keySet());
	}

}

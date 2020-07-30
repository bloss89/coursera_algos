package hashTables;

import java.util.HashMap;
import java.util.Map;

public class ExperimentEqHC {
	static int M=97;
	
	public static class Person0<Key,Value>{
		int id;
		public Person0(int id) {
			this.id = id;
		}
		public int hashCode() {
			return this.id;//(key.hashCode() & 0x7fffffff)%M;
		}
	}
	public static class Person1<Key,Value>{
		int id;
		public Person1(int id) {
			this.id = id;
		}
		public boolean equals(Object p) {
			if(((Person1)p).id==this.id)
				return true;
			else
				return false;
		}
	}
	
	public static class Person2<Key,Value>{
		int id;
		public Person2(int id) {
			this.id = id;
		}
		@Override
		public int hashCode() {
			//return (key.hashCode() & 0x7fffffff)%M;
			return this.id;
		}
		public boolean equals(Person2 p) {
			if(p.id==this.id)
				return true;
			else
				return false;
		}
	}
	public static class Person3<Key,Value>{
		int id;
		public Person3(int id) {
			this.id = id;
		}
		public int hashCode() {
			return this.id;//(key.hashCode() & 0x7fffffff)%M;
		}
		public boolean equals(Object p) {
			if(((Person3)p).id==this.id)
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		Person0 p01 = new Person0(1);
		Person0 p02 = new Person0(1);
		System.out.println("p0 hashcodes "+p01.hashCode()+"---"+p02.hashCode());//1
		Map<Person0,Integer> m1 = new HashMap<>(); 
		m1.put(p01, 10);
		m1.put(p02, 20);
		for(Person0 p : m1.keySet()) {
			System.out.println(m1.get(p).toString()+"---"+m1.get(p).hashCode());
		}
		if(p01.equals(p02))
			System.out.println("hash overriden and equal");//not equal - doesn't print
		
		Person1 p11 = new Person1(1);
		Person1 p12 = new Person1(1);
		System.out.println("p1 hashcodes "+p11.hashCode()+"---"+p12.hashCode());//random values
		Map<Person1,Integer> m2 = new HashMap<>(); 
		m2.put(p11, 10);
		m2.put(p12, 20);
		for(Person1 p : m2.keySet()) {
			System.out.println(m2.get(p).toString()+"---"+m2.get(p).hashCode());
		}
		if(p11.equals(p12))
			System.out.println("equals overriden and equal");//equal
		
		Person2 p21 = new Person2(1);
		Person2 p22 = new Person2(1);
		System.out.println("p2 hashcodes "+p21.hashCode()+"---"+p22.hashCode());//1
		Map<Person2,Integer> m3 = new HashMap<>(); 
		m3.put(p21, 10);
		m3.put(p22, 20);
		for(Person2 p : m3.keySet()) {
			System.out.println(m3.get(p).toString()+"---"+m3.get(p).hashCode());
		}
		if(p21.equals(p22))
			System.out.println("hash+equals person overriden and equal");//equal
		
		Person3 p31 = new Person3(1);
		Person3 p32 = new Person3(1);
		System.out.println("p3 hashcodes "+p31.hashCode()+"---"+p32.hashCode());//1
		Map<Person3,Integer> m4 = new HashMap<>(); 
		m4.put(p31, 10);
		m4.put(p32, 20);
		for(Person3 p : m4.keySet()) {
			System.out.println(m4.get(p).toString()+"---"+m4.get(p).hashCode());//only one element - as hash matches, first one gets replaced
		}
		if(p31.equals(p32))
			System.out.println("hash+equals obj overriden and equal");//equal

	}

}

package hashTables;

public class SeparateChaining<Key,Value> {
	
	private int M=97;
	private Node[] st = new Node[M];
	
	private static class Node{
		private Object key;
		private Object val;
		private Node next;
		
		Node(Object key,Object val,Node next) {
			this.key = key;
			this.val=val;
			this.next=next;
		}
	}

	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public Value get(Key key) {
		int i = hash(key);
		for(Node x=st[i];x!=null;x=x.next)
			if(key.equals(x.key))
				return (Value) x.val;
		return null;			
	}
	public void put(Key key, Value val) {
		int i = hash(key);
		for(Node x=st[i];x!=null;x=x.next) {
			if(key.equals(x.key)) {
				x.val=val;
				return;
			}
		}
		st[i] = new Node(key,val,st[i]);
		
	}
	
	public void print() {
		SeparateChaining sc = new SeparateChaining();
		for(int i=0;i<M;i++) {
			Node n = st[i];
			if(n!=null) {
				System.out.print(i+"----"+sc.hash(i)+":"+n.val);
				while(n.next!=null) {
					n = n.next;
					System.out.print(", "+n.val);
				}
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		SeparateChaining sc = new SeparateChaining();
		for(int i=0;i<100;i++) {
			sc.put("key"+i,"val"+i);
		}
		sc.print();
		System.out.println("fetch key99 "+sc.get("key99"));
	}

}

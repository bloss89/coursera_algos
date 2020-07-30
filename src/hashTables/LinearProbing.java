package hashTables;

public class LinearProbing<Key,Value> {
	private int M=30001;
	private Value[] vals = (Value[]) new Object[M];
	private Key[] keys = (Key[]) new Object[M];
	
	private int hash(Key key) {
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public void put(Key key, Value val) {
		int i;
		for(i=hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key))
				break;
		keys[i] = key;
		vals[i] = val;
	}
	public Value get(Key key) {
		for(int i=hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key))
				return vals[i];
		return null;
	}
	public void print() {
		int l = keys.length;
		for(int j=0;j<l;j++) {
			if(keys[j]!=null)
				System.out.println(j+"----"+keys[j]+"---"+vals[j]);
		}
	}
	public static void main(String[] args) {
		LinearProbing lp = new LinearProbing();
		for(int i=0;i<100;i++) {
			lp.put("key"+i,"val"+i);
		}	
		lp.print();
		System.out.println("fetch key9 "+lp.get("key9"));

	}

}

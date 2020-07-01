package Union;

public class WeightedQuickUnion {

	private int[] id;
	private int[] sz;
	
	public WeightedQuickUnion(int N) {
		id = new int[N];
		for(int i=0;i<N;i++) {
			id[i]=i;
		}
		sz = new int[N];
		for(int i=0;i<N;i++) {
			sz[i]=1;
		}
	}
	public void print() {
		System.out.println("************************");
		int n = id.length;
		for(int i=0;i<n;i++) {
			System.out.println(i+"---------"+id[i]+"--------"+sz[i]);
		}
	}
	public int root(int i) {
		while(i!=id[i]) {//go all the way up till you find an element whose root is itself
			i=id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		if(root(p)==root(q)) {
			System.out.println("Connected");
			return true;
		}
		else {
			System.out.println("Not Connected");
			return false;
		}
	}
	
	public void union(int p, int q) {
		// unite the sets by setting the root of small set root to large set root
		//balance trees by always choosing the smaller tree to link up to larger tree
		int proot = root(p),qroot = root(q);
		if(proot==qroot) return;
		if(sz[proot]<sz[qroot]) {
			id[proot] = qroot;
			sz[qroot]+=sz[proot];
		}else{
			id[qroot] = proot;
			sz[proot]+=sz[qroot];
		}
		//print();
	}

	public static void main(String[] args) {
		WeightedQuickUnion wqu = new WeightedQuickUnion(10);
		wqu.union(4, 3);
		wqu.union(3, 8);
		wqu.union(6, 5);
		wqu.union(9, 4);
		wqu.union(2, 1);
		wqu.connected(0, 7);
		wqu.connected(8, 9);
		wqu.union(5, 0);
		wqu.union(7, 2);
		wqu.connected(0, 7);
		wqu.union(6, 1);
		wqu.union(7,3);
		wqu.print();

	}

}

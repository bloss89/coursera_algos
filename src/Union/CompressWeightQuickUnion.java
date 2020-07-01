package Union;

public class CompressWeightQuickUnion {

		private int[] id;
		private int[] sz;
		
		public CompressWeightQuickUnion(int N) {
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
				id[i]=id[id[i]];//point each node on path to grandparent to flatten the tree
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
			CompressWeightQuickUnion cwqu = new CompressWeightQuickUnion(10);
			cwqu.union(4, 3);
			cwqu.union(3, 8);
			cwqu.union(6, 5);
			cwqu.union(9, 4);
			cwqu.union(2, 1);
			cwqu.connected(0, 7);
			cwqu.connected(8, 9);
			cwqu.union(5, 0);
			cwqu.union(7, 2);
			cwqu.connected(0, 7);
			cwqu.union(6, 1);
			cwqu.union(7,3);
			cwqu.print();

		}


}

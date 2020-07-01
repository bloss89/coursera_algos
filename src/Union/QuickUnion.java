package Union;

public class QuickUnion {
	
		private int[] id;
		
		public QuickUnion(int N) {
			id = new int[N];
			for(int i=0;i<N;i++) {
				id[i]=i;
			}
		}
		public void print() {
			System.out.println("************************");
			int n = id.length;
			for(int i=0;i<n;i++) {
				System.out.println(i+"---------"+id[i]);
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
			// unite the sets by setting the root of first set root to second set root
			int proot = root(p),qroot = root(q);
			id[proot] = qroot;
			//print();
		}

		public static void main(String[] args) {
			QuickUnion qu = new QuickUnion(10);
			qu.union(4, 3);
			qu.union(3, 8);
			qu.union(6, 5);
			qu.union(9, 4);
			qu.union(2, 1);
			qu.connected(0, 7);
			qu.connected(8, 9);
			qu.union(5, 0);
			qu.union(7, 2);
			qu.connected(0, 7);
			qu.union(6, 1);
			qu.union(7,3);
			qu.print();

		}

}

package Union;

public class CWQuickUnionMaxMin {

			private int[] id;
			private int[] sz;
			private int[] max;
			private int[] min;
			
			public CWQuickUnionMaxMin(int N) {
				id = new int[N];
				for(int i=0;i<N;i++) {
					id[i]=i;
				}
				sz = new int[N];
				for(int i=0;i<N;i++) {
					sz[i]=1;
				}
				max = new int[N];
				for(int i=0;i<N;i++) {
					max[i]=i;
				}
				min = new int[N];
				for(int i=0;i<N;i++) {
					min[i]=i;
				}
			}
			public void print() {
				System.out.println("************************");
				int n = id.length;
				for(int i=0;i<n;i++) {
					System.out.println(i+"---------"+id[i]+"--------"+sz[i]+"--------"+max[i]+"--------"+min[i]);
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
			
		/*	
			public int max(int p, int q) {
				return (p>=q? p : q);
			}
			public int min(int p, int q) {
				return (p<=q? p : q);
			}*/
			public int maxInConnComp(int x) {
				int n = id.length;
				int tmp = 0;
				for(int i=0;i<n;i++) {
					if(root(i)==x) {//eles in same component - with same root
						if(i>tmp) {
							tmp = i;
						}
					}
				}
				return tmp;
			}
			public int findMax(int x) {
				return maxInConnComp(root(x));
			}
			public int findMin(int x) {
				return minInConnComp(root(x));
			}
			public int minInConnComp(int x) {
				int n = id.length;
				int tmp = 0;
				for(int i=0;i<n;i++) {
					if(root(i)==x) {//eles in same component - with same root
						if(i<tmp) {
							tmp = i;
						}
					}
				}
				return tmp;
			}
			public void union(int p, int q) {
				// unite the sets by setting the root of small set root to large set root
				//balance trees by always choosing the smaller tree to link up to larger tree
				int proot = root(p),qroot = root(q);
				if(proot==qroot) return;
				if(sz[proot]<sz[qroot]) {
					id[proot] = qroot;
					max[qroot] = maxInConnComp(qroot);
					min[qroot] = minInConnComp(qroot);
					sz[qroot]+=sz[proot];
					
				}else{
					id[qroot] = proot;
					max[proot] = maxInConnComp(proot);
					min[proot] = minInConnComp(proot);
					sz[proot]+=sz[qroot];
				}
				//print();
			}

			public static void main(String[] args) {
				CWQuickUnionMaxMin cwqu = new CWQuickUnionMaxMin(10);
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
				System.out.println(cwqu.findMax(7));
				System.out.println(cwqu.findMin(7));
			}


}

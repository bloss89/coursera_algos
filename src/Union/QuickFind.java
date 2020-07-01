package Union;

public class QuickFind {
	
	private int[] id;
	
	public QuickFind(int N) {
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
	
	public boolean connected(int p, int q) {
		if(id[p]==id[q])
			return true;
		else
			return false;
	}
	
	public void union(int p, int q) {
		//get all elements with p's id
		//change ids to q's id
		int n = id.length, pid = id[p], qid = id[q];
		for(int i=0;i<n;i++) {
			if(id[i] == pid) {
				id[i]=qid;
			}
		}
	}

	public static void main(String[] args) {
		QuickFind qf = new QuickFind(10);
		qf.union(4, 3);
		qf.union(3, 8);
		qf.union(6, 5);
		qf.union(9, 4);
		qf.union(2, 1);
		qf.connected(0, 7);
		qf.connected(8, 9);
		qf.union(5, 0);
		qf.union(7, 2);
		qf.connected(0, 7);
		qf.union(1, 0);
		qf.union(6, 1);
		qf.print();

	}

}

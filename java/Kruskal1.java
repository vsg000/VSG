import java.util.*;


public class Kruskal1 {
	static class Edge implements Comparable<Edge>{
		int src;
		int dest;
		int wt;
		
		Edge(int s, int d, int w) {
			this.src= s;
			this.dest = d;
			this.wt = w;
		}

		@Override
		public int compareTo(Edge e2) {
			// TODO Auto-generated method stub
			return Integer.compare(this.wt, e2.wt);
		}
	}
	static int V = 4;
	static int[] par = new int[V];
	static int[] rank = new int[V];
	
	static void init() {
		for (int i = 0; i < V; i++) {
			par[i] = i;
			rank[i] = 0;
		}
	}
	
	static void createGraph(ArrayList<Edge> edges) {
		edges.add(new Edge(0, 1, 10));
		edges.add(new Edge(0, 2, 15));
		edges.add(new Edge(0, 3, 30));
		edges.add(new Edge(1, 3, 40));
		edges.add(new Edge(2, 3, 50));
		
	}
	
	static void kruskalMst(ArrayList<Edge> edges) {
		//sort the edge
		Collections.sort(edges);
		int count = 0;
		int mstCost = 0;
		
		for (int i = 0; count < V-1; i++) {
			Edge e = edges.get(i);
			//src, dest, wt
			
			int parA = find(e.src);
			int parB = find(e.dest);
			if(parA != parB) {
				union(parA, parB);
				System.out.println(e.src + "----" + e.dest + " = " + e.wt);
				mstCost += e.wt;
				count++;
			}
		}
		System.out.println("Total cost of that MST : " + mstCost);
		
	}
	static int find(int x) {
		if(x == par[x]) {
			return x;
		}
		//path compression technique
		par[x] = find(par[x]);
		
		return par[x];
	}
	
	static void union(int a, int b) {
		int parA = find(a);
		int parB = find(b);
		
		//cycle detection 
		if(parA == parB) {
			return;
		}
		if(rank[parA] == rank[parB]) {
			par[parB] = parA;
			rank[parA]++;
		}else if(rank[parA] < rank[parB]) {
			par[parA] = parB;
		}else {
			par[parB] = parA;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
		
		ArrayList<Edge> edges = new ArrayList<>();
		createGraph(edges);
		kruskalMst(edges);

		
		

	}

}
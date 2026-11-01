import java.util.*;
public class Dijkstra {
	
	static class Edge {
		int src;
		int dest;
		int wt;
		
		Edge(int s, int d, int w) {
			this.src = s;
			this.dest = d;
			this.wt = w;
		}
	}
	
	static class Pair implements Comparable<Pair> {
		int n;
		int path;
		
		Pair(int n, int path) {
			this.n = n;
			this.path = path;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.path, o.path); //path based sorting for pairs
			
		}
	}
	static void createGraph(ArrayList<Edge>[] graph) {
		graph[0].add(new Edge(0, 1, 2));
		graph[0].add(new Edge(0, 2, 4));
		
		//1 vertex
		graph[1].add(new Edge(1, 3, 7));
		graph[1].add(new Edge(1, 2, 1));
		
		//2 vertex
		
		graph[2].add(new Edge(2, 4, 3));
		
		//3 vertex
		graph[3].add(new Edge(3, 5, 1));
		
		//4 vertex
		graph[4].add(new Edge(4, 3, 2));
		graph[4].add(new Edge(4, 5, 5));
	}
	static void dijkstra(ArrayList<Edge>[] graph, int src) {
		int[] dist = new int[graph.length];
		
		for (int i = 0; i < graph.length; i++) {
			if(i != src) {
				dist[i] = Integer.MAX_VALUE;
			}
		}
		boolean[] visited = new boolean[graph.length];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.add(new Pair(src, 0));
		
		while(!pq.isEmpty()) {
			Pair curr = pq.remove();
			
			if(!visited[curr.n]) {
				visited[curr.n] = true;
				
				for (int i = 0; i < graph[curr.n].size(); i++) {
					Edge e = graph[curr.n].get(i);
					int u = e.src;
					int v = e.dest;
					int wt = e.wt;
					if(dist[u] + wt < dist[v]) {
						dist[v] = dist[u] + wt;
						pq.add(new Pair(v, dist[v]));
					}

				}
			}
		}
		for (int i = 0; i < dist.length; i++) {
			System.out.print(dist[i] + "   ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 6;
		ArrayList<Edge>[] graph = new ArrayList[v];
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		createGraph(graph);
//		printAdj(graph);
		int src = 0;
		dijkstra(graph, src);

	}

}
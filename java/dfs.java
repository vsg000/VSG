import java.util.*;
public class dfs {
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
	
	static void createGraph(ArrayList<Edge>[] graph) {
		// 0 vertex
		graph[0].add(new Edge(0, 1, 1));
		graph[0].add(new Edge(0, 2, 1));
		
		//1 vertex
		graph[1].add(new Edge(1, 0, 1));
		graph[1].add(new Edge(1, 3, 1));
		
		//2 vertex
		graph[2].add(new Edge(2, 0, 1));
		graph[2].add(new Edge(2, 5, 1));
		
		//3 vertex
		graph[3].add(new Edge(3, 1, 1));
		graph[3].add(new Edge(3, 4, 1));
		
		//4 vertex
		graph[4].add(new Edge(4, 3, 1));
		
		//5 vertex
		graph[5].add(new Edge(5, 2, 1));
	}
	static void printAdj(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + "-> ");
			
			for (int j = 0; j < graph[i].size(); j++) {
				Edge e = graph[i].get(j);
				System.out.print(e.dest + "   ");
			}
			System.out.println();
		}
	}
	static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited) {
		visited[curr] = true;
		System.out.print(curr + "     ");
		
		//find all neighbour
		for (int i = 0; i < graph[curr].size(); i++) {
			Edge e = graph[curr].get(i);
			
			if(!visited[e.dest]) {
				dfs(graph, e.dest, visited);
			}
		}
	}
	static void bfs(ArrayList<Edge>[] graph) {
		boolean[] visited = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			int curr = q.remove();
			if (!visited[curr]) {
				System.out.print(curr + "   ");
				visited[curr] = true;
				
				for (int i = 0; i < graph[curr].size(); i++ ) {
					Edge e = graph[curr].get(i);
					q.add(e.dest);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		int V = 6;
		ArrayList<Edge>[] graph = new ArrayList[V];
		
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>(); //empty arrayList
		}
		createGraph(graph);
		System.out.println("\n====ADJACENCY LIST====");
		printAdj(graph);
		
		boolean[] visited = new boolean[graph.length];
		System.out.print("DFS traversal of this graph : ");
		dfs(graph, 0, visited);
		
		System.out.print("\nBFS traversal of this graph : ");
		bfs(graph);
		
	}

}
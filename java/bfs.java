import java.util.*;

class Edge {
    int src;
    int desh;
    int wt;

    Edge(int s, int d, int w) {
        this.src = s;
        this.desh = d;
        this.wt = w;
    }
}

public class dfs {

    static void DFS(ArrayList<Edge>[] graph, int curr, boolean[] visited) {

         
        System.out.print(curr + " ");
        visited[curr] = true;

         for (int i = 0; i < graph[curr].size(); i++) {

            Edge e = graph[curr].get(i);

            if (!visited[e.desh]) {
                DFS(graph, e.desh, visited);
            }
        }
    }

    public static void main(String[] args) {

        int v = 6;

        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 5, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

        graph[5].add(new Edge(5, 2, 1));

        // DFS
        boolean[] visited = new boolean[v];

        DFS(graph, 0, visited);
    }
}
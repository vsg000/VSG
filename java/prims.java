 


import java.util.Scanner;

public class prims {



    public static void main(String[] args) {

        Scanner Sc = new Scanner(System.in);
 
        System.out.println("Enter no of vertex:");
        int v = Sc.nextInt();

        System.out.println("Enter the edges:");
        int e = Sc.nextInt();

        int[][] graph = new int[v][v];

        for (int i = 0; i < e; i++) {

            System.out.println("Enter source vertex:");
            int src = Sc.nextInt();

            System.out.println("Enter destination vertex:");
            int dest = Sc.nextInt();

            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }

        System.out.println("====ADJACENCY MATRIX===");
        
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

        Sc.close();
    }
}
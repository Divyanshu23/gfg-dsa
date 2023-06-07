import java.util.ArrayList;
import java.util.ArrayDeque;

public class BreadthFirstSearch {
    public static void main (String[] args) {
        int V = 7;

        var adj = new ArrayList<ArrayList<Integer> >(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1); 
        addEdge(adj,0,2); 
        addEdge(adj,2,3); 
        addEdge(adj,1,3); 
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,4,6);
        BFS(adj);
    }

    public static void BFS(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                BFSConnected(adj, i, visited);
            }
        }
        System.out.println();
    }

    private static void BFSConnected(ArrayList<ArrayList<Integer> > adj, int s, boolean[] visited) {
        var q = new ArrayDeque<Integer>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (var v : adj.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

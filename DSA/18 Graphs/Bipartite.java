import java.util.ArrayDeque;
import java.util.ArrayList;

public class Bipartite {
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
        System.out.println(isBipartite(adj));
    }

    private static boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int[] color = new int[V];

        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                if(!BFS(adj, V, i, visited, color))
                    return false;
            }
        }

        return true;
    }

    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int V, int s, boolean[] visited, int[] color) {
        var q = new ArrayDeque<Integer>();
        q.add(s);
        visited[s] = true;
        color[s] = 1;

        int u;
        while (!q.isEmpty()) {
            u = q.poll();
            for (var v : adj.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    if(color[u] == 1) {
                        color[v] = 2;
                    } else {
                        color[v] = 1;
                    }
                    q.add(v);
                } else if(color[v] == color[u])
                    return false;
            }
        }
        return true;
    }

    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
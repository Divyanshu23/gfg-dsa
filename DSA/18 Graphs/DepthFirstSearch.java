import java.util.ArrayList;

public class DepthFirstSearch {
    public static void main (String[] args) {
        int V = 5;

        var adj = new ArrayList<ArrayList<Integer> >(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj,0,1); 
        addEdge(adj,0,2); 
        addEdge(adj,1,2);
        addEdge(adj,3,4);
        DFS(adj);
    }

    private static void DFS(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSRec(adj, i, visited);
            }
        }
        System.out.println();
    }

    private static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited) {
        visited[s]  = true;
        System.out.print(s + " ");
        for (var v : adj.get(s)) {
            if(!visited[v]) {
                DFSRec(adj, v, visited);
            }
        }
    }

    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

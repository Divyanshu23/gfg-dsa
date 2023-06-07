import java.util.ArrayList;

public class Bridges {
    public static void main (String[] args) {
        int V = 5;
        var adj = new ArrayList<ArrayList<Integer> >(V);
        for (int j = 0; j < V; j++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 1, 0); 
		addEdge(adj, 0, 2); 
		addEdge(adj, 2, 1); 
		addEdge(adj, 0, 3); 
		addEdge(adj, 3, 4);

        bridges(adj);
    }

    private static int dTime = 0;

    private static void bridges(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];

        int[] discovery = new int[V];
        int[] low = new int[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSRec(adj, i, -1, visited, discovery, low, recStack);
            }
        }

        System.out.println();
    }

    private static void DFSRec(ArrayList<ArrayList<Integer> > adj, int u, int parent, boolean[] visited, int[] discovery,
                                int[] low, boolean[] recStack) {
        discovery[u] = low[u] = ++dTime;
        visited[u] = true;
        recStack[u] = true;

        for (var v : adj.get(u)) {
            if(!visited[v]) {
                DFSRec(adj, v, u, visited, discovery, low, recStack);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > discovery[u])
                    System.out.println(u + " " + v);

            } else if(v != parent && recStack[v]) {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }

        recStack[u] = false;
    }

    private static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

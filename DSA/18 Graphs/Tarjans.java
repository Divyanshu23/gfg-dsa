import java.util.ArrayDeque;
import java.util.ArrayList;

// O(V+E) 
// One traversal of graph

public class Tarjans {
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

        stronglyConnectedComponents(adj);
    }

    private static int dTime = 0;
    private static void stronglyConnectedComponents(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        int[] discovery = new int[V];
        int[] low = new int[V];

        var st = new ArrayDeque<Integer>();


        for (int i = 0; i < V; i++) {
            if(!visited[i])
                DFSRec(adj, i, -1, visited, discovery, low, recStack, st);
        }
    }

    private static void DFSRec(ArrayList<ArrayList<Integer>> adj, int u, int parent, boolean[] visited, int[] discovery, int[] low, boolean[] recStack, ArrayDeque<Integer> st) {
        recStack[u] = true;
        visited[u] = true;
        discovery[u] = low[u] = ++dTime;
        st.push(u);

        for (var v : adj.get(u)) {
            if(!visited[v]) {
                DFSRec(adj, v, u, visited, discovery, low, recStack, st);
                low[u] = Math.min(low[u], low[v]);

            } else if(recStack[v]) {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }

        if(low[u] == discovery[u]) {
            while (!st.isEmpty() && st.peek() != u) {
                recStack[st.peek()] = false;
                System.out.print(st.pop() + " ");
            }
            if(!st.isEmpty() && st.peek() == u) {
                recStack[st.peek()] = false;
                System.out.print(st.pop() + " ");
            }
            System.out.println();
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
    }
}

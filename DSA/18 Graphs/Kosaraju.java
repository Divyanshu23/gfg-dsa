import java.util.ArrayDeque;
import java.util.ArrayList;

public class Kosaraju {     // O (V+E) algo. Tarjan's Algo is faster
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

    private static void stronglyConnectedComponents(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();
        var st = topologicalSortDFS(adj);
        var adjTranspose = transposeGraph(adj);

        boolean[] visited = new boolean[V];

        int s;
        while(!st.isEmpty()) {
            s = st.pop();
            if(!visited[s]) {
                BFSConnected(adjTranspose, s, visited);
            }
        }
    }

    private static void BFSConnected(ArrayList<ArrayList<Integer> > adjTranspose, int s, boolean[] visited) {
        visited[s] = true;
        var q = new ArrayDeque<Integer>();
        q.add(s);

        int u;
        while (!q.isEmpty()) {
            u = q.poll();
            System.out.print(u + " ");
            for (var v : adjTranspose.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        System.out.println();
    }

    private static ArrayList<ArrayList<Integer> > transposeGraph(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        var adj2 = new ArrayList<ArrayList<Integer> >(V);
        for (int j = 0; j < V; j++)
            adj2.add(new ArrayList<Integer>());

        for (int u = 0; u < V; u++) {
            for (var v : adj.get(u)) {
                adj2.get(v).add(u);
            }
        }

        return adj2;
    }

    private static ArrayDeque<Integer> topologicalSortDFS(ArrayList<ArrayList<Integer> > adj) {
        var st = new ArrayDeque<Integer>();
        int V = adj.size();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSRec(adj, i, visited, st);
            }
        }
        return st;
    }

    private static void DFSRec(ArrayList<ArrayList<Integer> > adj, int s, boolean[] visited, ArrayDeque<Integer> st) {
        visited[s] = true;

        for (var v : adj.get(s)) {
            if(!visited[v])
                DFSRec(adj, v, visited, st);
        }

        st.push(s);
    }

    private static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) { adj.get(u).add(v); } 
}

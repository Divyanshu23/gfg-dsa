import java.util.ArrayList;
import java.util.ArrayDeque;

public class DetecCycleUndirected {
    public static void main (String[] args) {
        int V = 6; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

		addEdge(adj,0,1); 
        addEdge(adj,1,2); 
        addEdge(adj,2,4); 
        addEdge(adj,4,5); 
        addEdge(adj,1,3);
        addEdge(adj,2,3);

        System.out.println(detectCycleDFSBased(adj));
        System.out.println(detectCycleBFSBased(adj));
    }

    public static boolean detectCycleDFSBased(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(DFSRec(adj, i, -1, visited))
                    return true;
            }
        }
        return false;
    }

    private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int u, int parent, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if(!visited[v]) {
                if(DFSRec(adj, v, u, visited))
                    return true;
            } else if(v != parent)
                return true;
        }
        return false;
    }

    private static boolean detectCycleBFSBased(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(BFSConnected(adj, i, visited, parent))
                    return true;
            }
        }
        return false;
    }

    private static boolean BFSConnected(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, int[] parent) {
        parent[s] = -1;
        var q = new ArrayDeque<Integer>();
        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    parent[v] = u;
                    q.add(v);
                } else if(parent[u] != v)
                    return true;
            }
        }

        return false;
    }

    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}

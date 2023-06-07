import java.util.ArrayList;
import java.util.ArrayDeque;

public class TopologicalSort {
    public static void main (String[] args) {
        int V = 5; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

		addEdge(adj,0, 2); 
        addEdge(adj,0, 3); 
        addEdge(adj,1, 3); 
        addEdge(adj,1, 4); 
        addEdge(adj,2, 3);

        topologicalSortBFSBased(adj);   // Kahn's Algorithm
        topologicalSortDFSBased(adj);   // DFS Based solution
    }

    public static void topologicalSortBFSBased(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();        
        int[] inDegree = new int[V];

        for(int i=0;i<V;i++) {
            for(int j=0;j<adj.get(i).size();j++) {
                inDegree[adj.get(i).get(j)]++;
            }
        }

        var q = new ArrayDeque<Integer>();
        for (int i=0;i<V;i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        int u;
        while (!q.isEmpty()) {
            u = q.poll();
            System.out.print(u + " ");
            for (var v : adj.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0)
                    q.add(v);
            }
        }
        System.out.println();
    }

    public static void topologicalSortDFSBased(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        var st = new ArrayDeque<Integer>();

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSRec(adj, i, visited, st);
            }
        }

        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
        System.out.println();
    }

    private static void DFSRec(ArrayList<ArrayList<Integer>> adj, int s, boolean[] visited, ArrayDeque<Integer> st) {
        visited[s] = true;
        for (var v : adj.get(s)) {
            if(!visited[v])
                DFSRec(adj, v, visited, st);
        }
        st.push(s);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) { 
		adj.get(u).add(v); 
	}
}

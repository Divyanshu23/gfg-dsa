import java.util.ArrayList;
import java.util.ArrayDeque;

public class DetecCycleDirected {
    public static void main (String[] args) {
        int V = 6; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);
		
		for (int i = 0; i < V; i++)
			adj.add(new ArrayList<Integer>());

		addEdge(adj,0,1);
        addEdge(adj,2,1);
        addEdge(adj,2,3);
        addEdge(adj,3,4);
        addEdge(adj,4,5);
        addEdge(adj,5,3);

        System.out.println(detecCycleDFSBased(adj));
        System.out.println(detecCycleBFSBased(adj));
    }

    private static boolean detecCycleDFSBased(ArrayList<ArrayList<Integer> > adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(DFSRec(adj, i, visited, recStack))
                    return true;
            }
        }
        return false;
    }

    private static boolean DFSRec(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, boolean[] recStack) {
        recStack[u] = true;
        visited[u] = true;

        for (int v : adj.get(u)) {
            if(!visited[v]) {
                if(DFSRec(adj, v, visited, recStack)) {
                    return true;
                }
            } else if(recStack[v])
                return true;
        }
        recStack[u] = false;
        return false;
    }

    private static boolean detecCycleBFSBased(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        int[] inDegree = new int[V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                inDegree[adj.get(i).get(j)]++;
            }
        }

        var q = new ArrayDeque<Integer>();
        for (int i=0;i<V;i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }

        int u;
        int count = 0;
        while (!q.isEmpty()) {
            u = q.poll();
            count++;

            for (var v : adj.get(u)) {
                inDegree[v]--;
                if(inDegree[v] == 0)
                    q.add(v);
            }
        }

        return (count != V);
    }

    public static void addEdge(ArrayList<ArrayList<Integer> > adj, int u, int v) {
        adj.get(u).add(v);
    }
}

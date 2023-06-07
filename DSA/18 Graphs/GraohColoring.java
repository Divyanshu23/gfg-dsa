import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;

public class GraohColoring {
    public static void main (String[] args) {
        int V = 4; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

		addEdge(adj,0,1); 
    	addEdge(adj,1,2); 
    	addEdge(adj,2,3); 
    	addEdge(adj,3,0);
    	addEdge(adj,0,2);
        int m = 3;
        if(colorGraph(adj, m))
            System.out.println("Yes, it is possible to color graph with maximum " + m + " colors.");
        else System.out.println("Not possible to color graph with maximum " + m + " colors.");
    }

    private static boolean colorGraph(ArrayList<ArrayList<Integer> > adj, int m) {
        int V = adj.size();
        int[] color = new int[V];
        Arrays.fill(color, 1);
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!visited[i]) {
                if(!BFSwithColor(adj, V, m, i, visited, color))
                    return false;
            }
        }
        return true;
    }

    private static boolean BFSwithColor(ArrayList<ArrayList<Integer> > adj, int V, int m, int s, boolean[] visited, int[] color) {
        var q = new ArrayDeque<Integer>(V);
        q.add(s);
        visited[s] = true;

        int u;
        int maxColors = 1;
        while (!q.isEmpty()) {
            u = q.poll();
            for (var v : adj.get(u)) {
                if(color[v] == color[u])
                    color[v]+=1;
                maxColors = Math.max(maxColors, Math.max(color[u], color[v]));
                if(maxColors > m)
                    return false;

                if(!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }

        return true;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v);
        adj.get(v).add(u);
	}
}

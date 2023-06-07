import java.util.ArrayList;

public class GraphColoring {
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
        if(graphColoring(adj,m,V)) 
            System.out.println("Yes, Possible!");
        else
            System.out.println("Not possible");
    }

    private static boolean graphColoring(ArrayList<ArrayList<Integer> > adj, int m, int V) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) color[i] = 0;

        if (graphColoringUtil(adj, m, color, 0, V) == false) {
            return false;
        }

        return true;
    }

    private static boolean graphColoringUtil(ArrayList<ArrayList<Integer> > adj, int m, int color[], int u, int V) {
        if (u == V) return true;

        for (int c = 1; c <= m; c++) {
            if (isSafe(u, adj, color, c, V)) {
                color[u] = c;
                if (graphColoringUtil(adj, m, color, u + 1, V) == true)
                    return true;
                color[u] = 0;
            }
        }
        return false;
    }

    private static boolean isSafe(int u, ArrayList<ArrayList<Integer> > adj, int color[], int c, int V) {
        for(var v:adj.get(u))
            if(color[v] == c)  return false;

        return true;
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v);
        adj.get(v).add(u);
	}
}

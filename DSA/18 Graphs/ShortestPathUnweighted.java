import java.util.ArrayList;
import java.util.ArrayDeque;

public class ShortestPathUnweighted {
    public static void main (String[] args) {
        int V = 4; 
		ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V); 
		
		for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<Integer>()); 

		addEdge(adj,0,1); 
    	addEdge(adj,1,2); 
    	addEdge(adj,2,3); 
    	addEdge(adj,0,2);
    	addEdge(adj,1,3);

		int[] distance = shortestPath(adj, 0);
		System.out.println("Shortest Path from vertex 0: ");
		for(int i=0;i<V;i++) {
			System.out.print(distance[i] + " ");
		}
		System.out.println();
    }

	public static int[] shortestPath(ArrayList<ArrayList<Integer> > adj, int s) {
		int V = adj.size();
		var distance = new int[V];
		for(int i=0;i<V;i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		var q = new ArrayDeque<Integer>();
		distance[s] = 0;
        q.add(s);

		while(!q.isEmpty()) {
			int u = q.poll();
			for(var v: adj.get(u)) {
				if(distance[v] == Integer.MAX_VALUE) {
					distance[v] = distance[u] + 1;
					q.add(v);
				}
			}
		}

		return distance;
	}

	public static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) 
	{ 
		adj.get(u).add(v); 
	}
}
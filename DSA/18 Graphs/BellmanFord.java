import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {    // O(VE) Works also for negative weight edges
    public static void main (String[] args) {
        int V = 4;
        var adj = new ArrayList<ArrayList<AdjListNode> >(V);
        for (int j = 0; j < V; j++)
            adj.add(new ArrayList<AdjListNode>());

        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 2, -8);
        addEdge(adj, 3, 1, 3);
        addEdge(adj, 2, 3, 2);

        var distance = shortestPath(adj, 0);

        for (var item : distance) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    private static int[] shortestPath(ArrayList<ArrayList<AdjListNode>> adj, int s) {
        int V = adj.size();
        var distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;

        for (int count = 0; count < V-1; count++) {
            for (int u = 0; u < V; u++) {
                for (var v : adj.get(u)) {
                    if(distance[v.getv()] > distance[u] + v.getWeight()) {
                        distance[v.getv()] = distance[u] + v.getWeight();
                    }
                }
            }
        }

        for (int u = 0; u < V; u++) {
            for (var v : adj.get(u)) {
                if(distance[v.getv()] > distance[u] + v.getWeight()) {
                    System.out.println("Negative Edge in Graph");
                }
            }
        }
        System.out.println("No negative edge in graph");

        return distance;
    }

    public static void addEdge(ArrayList<ArrayList<AdjListNode> > adj, int u, int v, int weight) {
        adj.get(u).add(new AdjListNode(v, weight));
    }

    private static class AdjListNode{
        int v;
        int weight;
    
        public AdjListNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    
        public int getv() {
            return this.v;
        }
    
        public int getWeight() {
            return this.weight;
        }
    }
}
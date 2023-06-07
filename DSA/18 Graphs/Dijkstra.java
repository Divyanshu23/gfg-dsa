import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

// Dijkstra doesn't works for Negative Weight Edges
// O((V+E)log(V))

public class Dijkstra {
    public static void main (String[] args) {
        int V = 4;;
        var adj = new ArrayList<ArrayList<AdjListNode> >(V);
        for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<AdjListNode>()); 

        addEdge(adj, 0, 1, 5);
        addEdge(adj, 0, 2, 8);
        addEdge(adj, 1, 2, 10);
        addEdge(adj, 1, 3, 15);
        addEdge(adj, 2, 3, 20);

        int[] distance = dijkstra(adj, 2);
        System.out.println("Distance of verticex from source: " + 0);
        for (int i = 0; i < V; i++) {
            System.out.print(i + ": " + distance[i] + " ");
        }
        System.out.println();
    }

    private static int[] dijkstra(ArrayList<ArrayList<Dijkstra.AdjListNode>> adj, int src) {
        int V = adj.size();

        boolean[] fixed = new boolean[V];
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        var pq = new PriorityQueue<AdjListNode>();
        pq.add(new AdjListNode(src, distance[src]));

        AdjListNode curr;
        while (!pq.isEmpty()) {
            curr = pq.poll();
            if(fixed[curr.getv()])
                continue;
            
            fixed[curr.getv()] = true;

            for (AdjListNode item : adj.get(curr.getv())) {
                if(!fixed[item.getv()] && distance[item.getv()] > distance[curr.getv()] + item.getWeight()) {
                    distance[item.getv()] = distance[curr.getv()] + item.getWeight();
                    pq.add(new AdjListNode(item.getv(), distance[item.getv()]));
                }
            }
        }

        return distance;
    }

    public static void addEdge(ArrayList<ArrayList<AdjListNode> > adj, int u, int v, int weight) {
        adj.get(u).add(new AdjListNode(v, weight));
        adj.get(v).add(new AdjListNode(u, weight));
    }

    private static class AdjListNode implements Comparable<AdjListNode> {
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
    
        @Override
        public int compareTo(AdjListNode o) {
            return this.getWeight() - o.getWeight();
        }
    }
}

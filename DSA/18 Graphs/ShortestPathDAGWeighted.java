import java.util.ArrayList;
import java.util.ArrayDeque;

public class ShortestPathDAGWeighted {
    public static void main (String[] args) {
        int V = 6;
        var adj = new ArrayList<ArrayList<AdjListNode> >(V);

        for (int i = 0; i < V; i++) 
			adj.add(new ArrayList<AdjListNode>()); 

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 4, 1);
        addEdge(adj, 1, 2, 3);
        addEdge(adj, 4, 2, 2);
        addEdge(adj, 4, 5, 4);
        addEdge(adj, 2, 3, 6);
        addEdge(adj, 5, 3, 1);

        var distance = shortestPath(adj, 0);

        for (int i = 0; i < V; i++) {
            System.out.print(distance[i] + " ");
        }
        System.out.println();
    }

    private static int[] shortestPath(ArrayList<ArrayList<AdjListNode>> adj, int s) {
        int V = adj.size();
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[s] = 0;

        int[] inDegree = new int[V];

        for(int i=0;i<V;i++) {
            for(int j=0;j<adj.get(i).size();j++) {
                inDegree[adj.get(i).get(j).getv()]++;
            }
        }

        var q =  new ArrayDeque<Integer>();
        for (int i=0;i<V;i++) {
            if(inDegree[i] == 0)
                q.add(i);
        }


        int u;
        var topologicalSort = new ArrayList<Integer>(V);
        while (!q.isEmpty()) {
            u = q.poll();
            topologicalSort.add(u);

            for (var v : adj.get(u)) {
                inDegree[v.getv()]--;
                if(inDegree[v.getv()] == 0)
                    q.add(v.getv());
            }
        }

        for (var item : topologicalSort) {
            if(distance[item] != Integer.MAX_VALUE) {
                for (var v : adj.get(item)) {
                    if(distance[v.getv()] > (distance[item] + v.getWeight()))
                       distance[v.getv()] = distance[item] + v.getWeight();
                }
            }
        }

        return distance;
    }

    private static void addEdge(ArrayList<ArrayList<AdjListNode> > adj, int u, int v, int weight) {
        adj.get(u).add(new AdjListNode(v, weight));
    }

    private static class AdjListNode {
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

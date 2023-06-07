import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.ArrayList;

// O(Elog(V))

public class MSTPrims {
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

        System.out.println(MST(adj));
    }

    public static int MST(ArrayList<ArrayList<AdjListNode> > adj) {
        int V = adj.size();
 
        int[] distFromMST = new int[V];
        Arrays.fill(distFromMST, Integer.MAX_VALUE);
        distFromMST[0] = 0;

        var pq = new PriorityQueue<AdjListNode>();
        pq.add(new AdjListNode(0, distFromMST[0]));

        boolean[] mstSet = new boolean[V];
        
        int res = 0;
        AdjListNode curr;
        while (!pq.isEmpty()) {
            curr = pq.poll();

            if(mstSet[curr.getv()])
                continue;
            
            mstSet[curr.getv()] = true;
            res += curr.getWeight();

            for (var item : adj.get(curr.getv())) {
                if(!mstSet[item.getv()] && distFromMST[item.getv()] > item.getWeight()) {
                    distFromMST[item.getv()] = item.getWeight();
                    pq.add(new AdjListNode(item.getv(), distFromMST[item.getv()]));
                }
            }
        }

        return res;
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
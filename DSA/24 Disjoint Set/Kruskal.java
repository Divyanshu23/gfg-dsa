import java.util.Arrays;

public class Kruskal {
    public static void main (String[] args) {
        int V = 5;
        var edges = new Edge[7];
        for(int i=0;i<7;i++) {
            edges[i] = new Edge();
        }

        addEdge(edges, 0, 1, 10, 0);
        addEdge(edges, 0, 2, 8, 1);
        addEdge(edges, 1, 2, 5, 2);
        addEdge(edges, 1, 3, 3, 3);
        addEdge(edges, 2, 3, 4, 4);
        addEdge(edges, 2, 4, 12, 5);
        addEdge(edges, 3, 4, 15, 6);

        parent = new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++) {
            parent[i] = i;
        }
        System.out.println(kruskal(edges, V));
    }

    private static int[] parent;
    private static int[] rank;

    private static int find(int x) {
        if(parent[x] == x)
            return x;
        
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int x, int y) {
        int prntX = find(x);
        int prntY = find(y);
        if(prntX == prntY)
            return;
        if(rank[prntX] < rank[prntY]) {
            parent[prntX] = prntY;
        } else if(rank[prntX] > rank[prntY]) {
            parent[prntY] = prntX;
        } else {
            parent[prntY] = prntX;
            rank[prntX]++;
        }
    }

    private static int kruskal(Edge[] edges, int V) {
        Arrays.sort(edges);

        int res = 0;
        int u, v;
        for(int i=0,s=0;s<V-1;i++) {
            u = find(edges[i].u);
            v = find(edges[i].v);

            if(u != v) {
                res += edges[i].w;
                union(edges[i].u, edges[i].v);
                s++;
            }
        }

        return res;
    }

    public static void addEdge(Edge[] edges, int u, int v, int weight, int i) {
        edges[i].u = u;
        edges[i].v = v;
        edges[i].w = weight;
    }

    private static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge() {};
    
    
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }
}

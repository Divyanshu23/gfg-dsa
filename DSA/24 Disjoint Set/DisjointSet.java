import java.util.Scanner;

public class DisjointSet {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var parent = new int[n];
        var rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        System.out.println(find(parent, n-1));
        union(parent, rank, n-2, n-1);
        System.out.println(find(parent, n-1));
        sc.close();
    }

    public static int find(int[] parent, int x) {
        if(parent[x] == x)
            return x;

        parent[x] = find(parent, parent[x]);
        return parent[x];
    }

    public static void union(int[] parent, int[] rank,int x, int y) {
        int prntX = find(parent, x);
        int prntY = find(parent, y);
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
}

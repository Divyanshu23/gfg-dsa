import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostPathWeightedGrid {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] mat = {
                        {9, 4, 9, 9}, 
                        {6, 7, 6, 4}, 
                        {8, 3, 3, 7}, 
                        {7, 4, 9, 10}
                    };
        System.out.println(minimumCostPath(mat));
        sc.close();
    }

    public static int minimumCostPath(int[][] grid)
    {
        int V = grid.length;
        
        int[][] distance = new int[V][V];
        for(var row:distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        boolean[][] fixed = new boolean[V][V];
        
        var pq = new PriorityQueue<Triplet>();
        distance[0][0] = grid[0][0];
        pq.add(new Triplet(0,0,distance[0][0]));
        
        Triplet curr;
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int row;
        int col;
        while(!pq.isEmpty()) {
            curr = pq.poll();
            row = curr.i;
            col = curr.j;
            
            if(fixed[row][col])
                continue;
                
            fixed[row][col] = true;
            
            for(int k=0;k<4;k++) {
                row = curr.i+dx[k];
                col = curr.j+dy[k];
                
                if(row >= 0 && row<V && col>=0 && col<V) {
                    if(!fixed[row][col] && distance[row][col] > distance[curr.i][curr.j] + grid[row][col]) {
                        distance[row][col] = distance[curr.i][curr.j] + grid[row][col];
                        pq.add(new Triplet(row, col, distance[row][col]));
                    }
                }
            }
            
        }
        return distance[V-1][V-1];
    }
    
    private static class Triplet implements Comparable<Triplet> {
        int i;
        int j;
        int w;
    
        public Triplet(int i, int j, int weight) {
            this.i = i;
            this.j = j;
            this.w = weight;
        }
    
        @Override
        public int compareTo(Triplet o) {
            return this.w - o.w;
        }
    }
}

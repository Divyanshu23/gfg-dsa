import java.util.Scanner;

public class BinaryKnapsack {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int n = sc.nextInt();
        var val = new int[n];
        var wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }
        System.out.println(maxValueBinaryKnapsack(W,val,wt));
        sc.close();
    }

    private static int maxValueBinaryKnapsack(int W, int[] val, int[] wt) {
        int n = val.length;
        var dp = new int[W+1][n+1];
        for (int i = 1; i <= W; i++) {
            for (int j = 1; j <= n; j++) {
                if(i >= wt[j-1]) {
                    dp[i][j] = Math.max(val[j-1]+dp[i-wt[j-1]][j-1],dp[i][j-1]);
                } else 
                    dp[i][j] = dp[i][j-1];
            }
        }

        return dp[W][n];
    }
}

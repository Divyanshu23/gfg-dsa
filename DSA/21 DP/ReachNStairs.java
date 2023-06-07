import java.util.Scanner;

// Number of ways to climb n stairs when jump of either 1 or 2 is allowed
// In two cases -- Order Matters i.e. 1,1,2 is different from 2,1,1
//              -- Order does not matter

public class ReachNStairs {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(orderMatters(n));
        System.out.println(orderDoesNotMatter(n));
        sc.close();
    }

    private static long orderMatters(int n) {
        var dp = new long[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++) {
            dp[i] = dp[i]+dp[i-1];
            if(i>=2) {
                dp[i] = dp[i] + dp[i-2];
            }
        }
        
        return dp[n];
    }


    // Exactly same as Coin Change problem
    private static long orderDoesNotMatter(int n) {
        var dp = new long[n+1][3];
        for (int j = 0; j <= 2; j++) {
            dp[0][j] = 1;
        }

        var steps = new int[2];
        steps[0] = 1;
        steps[1] = 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2; j++) {
                if(i >= steps[j-1]) {
                    dp[i][j] = dp[i - steps[j-1]][j] + dp[i][j-1];
                } else
                dp[i][j] = dp[i][j-1];
            }
        }

        return dp[n][2];
    }
}

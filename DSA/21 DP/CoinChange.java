import java.util.Scanner;

public class CoinChange {
    public static void main(String[] aStrings) {
        var sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = sc.nextInt();
        var denom = new int[n];
        for (int i = 0; i < n; i++) {
            denom[i] = sc.nextInt();
        }
        System.out.println(changeCoin(sum, denom));
        sc.close();
    }

    private static long changeCoin(int sum, int[] coins) {
        int n = coins.length;

        var dp = new long[sum+1][n+1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                if(i >= coins[j-1]) {
                    dp[i][j] = dp[i - coins[j-1]][j] + dp[i][j-1];
                } else
                dp[i][j] = dp[i][j-1];
            }
        }

        return dp[sum][n];
    }
}
import java.util.Scanner;

public class BSTsWithDistinctKeys {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(bSTsWithDistinctKeys(n));
        sc.close();
    }

    private static int bSTsWithDistinctKeys(int n) {
        var dp = new int[n+1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}

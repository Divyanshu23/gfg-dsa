import java.math.BigInteger;
import java.util.Scanner;

public class CatalanNumber {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int  n = sc.nextInt();
        System.out.println(catalanNumber(n));
        sc.close();
    }

    private static BigInteger catalanNumber(int n) {
        var dp = new BigInteger[n+1];
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");

        for (int i = 2; i <= n; i++) {
            dp[i] = new BigInteger("0");
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i].add(dp[j].multiply(dp[i-1-j]));
            }
        }

        return dp[n];
    }
}
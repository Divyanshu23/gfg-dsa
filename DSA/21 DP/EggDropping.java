import java.util.Scanner;

public class EggDropping {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(minEggDrops(n,k));
        sc.close();
    }

    private static int minEggDrops(int e, int f) {
        if (f == 1 || f == 0 || e == 1)
            return f;
 
        var dp = new int[e+1][f+1];

        for(int i=1;i<=e;i++) {
            dp[i][1] = 1;
        }

        for (int j = 1; j <= f; j++) {
            dp[1][j] = j;
        }

        int res;
        for(int i=2;i<=e;i++) {
            for (int j = 2;j<=f;j++) {
                res = Integer.MAX_VALUE;
                for (int x = 1; x <= j; x++) {
                    res = Math.min(res, 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]));
                }
                dp[i][j] = res;
            }
        }

        return dp[e][f];
    }
}
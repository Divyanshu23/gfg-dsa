import java.util.Scanner;

public class MaxSumNonConsecuitive {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSumNonConsecuitive(arr, n));
        sc.close();
    }
    
    private static long maxSumNonConsecuitive(int[] arr, int n) {
        var dp = new long[n+1];
        dp[1] = arr[0];
        
        for(int i=2;i<=n;i++) {
            if(dp[i-2] > 0) {
                dp[i] = Math.max(dp[i-1], dp[i-2]+arr[i-1]);
            } else {
                dp[i] = Math.max(dp[i-1], arr[i-1]);
            }
        }
        
        return dp[n];
    }
}

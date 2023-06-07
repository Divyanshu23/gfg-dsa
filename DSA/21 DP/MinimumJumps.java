import java.util.Scanner;

public class MinimumJumps {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minJumps(arr));
        sc.close();
    }

    private static int minJumps(int[] arr) {
        int n = arr.length;
        var dp = new int[n];
        for (int i = n-2; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= arr[i] && i+j<n ; j++) {
                if(dp[i+j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], 1+dp[i+j]);
            }
        }
        return dp[0] == Integer.MAX_VALUE ? -1 : dp[0];
    }
}

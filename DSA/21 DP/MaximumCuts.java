import java.util.Scanner;

public class MaximumCuts {
    public static void main(String[] Strings) {
        var sc = new Scanner(System.in);
        int len = sc.nextInt();
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxCuts(arr,len));
        sc.close();
    }

    private static int maxCuts(int[] arr, int len) {
        var dp = new int[len+1];
        int n = arr.length;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < n; j++) {
                if(i >= arr[j]) {
                    if(i == arr[j] || dp[i-arr[j]] != 0)
                        dp[i] = Math.max(dp[i], 1+dp[i-arr[j]]);
                }
            }
        }
        return dp[len];
    }
}

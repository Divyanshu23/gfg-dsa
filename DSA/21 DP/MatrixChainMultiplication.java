import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(matrixChainMultiplication(arr));
        sc.close();
    }

    private static int matrixChainMultiplication(int[] arr) {
        int n = arr.length;
        var dp = new int[n][n];
        int j;
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i+len-1 < n; i++) {
                j = i+len-1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], arr[i]*arr[k]*arr[j]+dp[i][k]+dp[k][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}

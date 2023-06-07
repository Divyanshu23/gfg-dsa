import java.util.Scanner;

public class OptimalStrategyGame {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        winningStrategy(arr);
        maxSumStrategy(arr);
        sc.close();
    }

    private static void winningStrategy(int[] arr) {
        int n = arr.length;
        int oddSum = arr[0];
        int evenSum = arr[1];

        for (int i = 2; i < n; i+=2) {
            oddSum += arr[i];
            evenSum += arr[i+1];
        }

        if(evenSum >= oddSum) {
            System.out.println("Use the strategy of always choosing an even positon coin");
            System.out.println("Value collected: " + evenSum);
            System.out.println("Opponent's Value: " + oddSum);
        } else {
            System.out.println("Use the strategy of always choosing an odd positon coin");
            System.out.println("Value collected: " + oddSum);
            System.out.println("Opponent's Value: " + evenSum);
        }
    }

    private static void maxSumStrategy(int[] arr) {
        int n = arr.length;
        var dp = new int[n][n];

        for (int i = 0; i+1 < n; i++) {
            dp[i][i+1] = Math.max(arr[i], arr[i+1]);
        }

        int j;
        for (int len = 4; len <= n; len++) {
            for (int i = 0; i+len-1 < n; i++) {
                j = i+len-1;
                dp[i][j] = Math.max(arr[i]+Math.min(dp[i+2][j], dp[i+1][j-1]), arr[j]+Math.min(dp[i+1][j-1], dp[i][j-2]));
            }
        }
        System.out.println(dp[0][n-1]);
    }
}

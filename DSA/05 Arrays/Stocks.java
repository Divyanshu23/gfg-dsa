import java.util.Scanner;

public class Stocks {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProfit(arr, n));
        System.out.println(maxProfitNaive(arr, 0, n-1));
        sc.close();
    }

    public static int maxProfit(int[] arr, int n) {
        int maxProfit = 0;

        for (int i = 1; i < n; i++) {
            if(arr[i] >= arr[i-1]) maxProfit += arr[i] - arr[i-1];
        }
        return maxProfit;
    }

    public static int maxProfitNaive(int[] arr, int start, int end) {
        if(start >= end) return 0;
        int maxProfit = 0;
        int currProfit;
        for (int i = start; i <= end; i++) {
            for (int j = i+1; j <= end; j++) {
                if(arr[j] >= arr[i]) {
                    currProfit = arr[j] - arr[i] + maxProfitNaive(arr, start, i-1) + maxProfitNaive(arr, j+1, end);
                    maxProfit = Math.max(maxProfit, currProfit);
                }
            }
        }
        return maxProfit;
    }
}
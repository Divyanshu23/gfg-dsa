import java.util.Scanner;

public class MaxSumIncreasingSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSumIncreasingSubsequence(arr));
        sc.close();
    }

    private static int maxSumIncreasingSubsequence(int[] arr) {
        int n = arr.length;
        var msis = new int[n];
        msis[0] = arr[0];

        for (int i = 1; i < n; i++) {
            msis[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i])
                    msis[i] = Math.max(msis[i], msis[j]+arr[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, msis[i]);
        }
        return max;
    }
}
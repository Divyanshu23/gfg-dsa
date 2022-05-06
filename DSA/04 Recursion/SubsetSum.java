import java.util.Scanner;

public class SubsetSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(subsetSum(arr, n, sum, 0));
        sc.close();
    }

    public static int subsetSum(int[] arr, int n, int sum, int start) {
        if(start >= n) return (sum == 0) ? 1:0;

        int count = subsetSum(arr, n, sum, start+1) + subsetSum(arr, n, sum - arr[start], start+1);
        return count;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSubarraySum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(maxSubarraySum(arr));
        sc.close();
    }

    public static int maxSubarraySum(ArrayList<Integer> arr) {
        int maxSum = arr.get(0);
        int maxEnding = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            maxEnding = Math.max(maxEnding + arr.get(i), arr.get(i));
            maxSum = Math.max(maxSum, maxEnding);
        }
        return maxSum;
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class MaxCircularSubarraySum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println(getMaxCircularSubarraySum(arr));
        sc.close();
    }

    public static int getMaxCircularSubarraySum(ArrayList<Integer> arr) {
        int maxNormal = getMaxNormalSubarraySum(arr);
        if(maxNormal < 0)
            return maxNormal;
        int sum = arr.get(0), minSum = arr.get(0), minEnding = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            minEnding = Math.min(minEnding + arr.get(i), arr.get(i));
            minSum = Math.min(minSum, minEnding);
            sum += arr.get(i);
        }
        int maxCircular = sum - minSum;
        return Math.max(maxCircular, maxNormal);
    }

    public static int getMaxNormalSubarraySum(ArrayList<Integer> arr) {
        int maxSum = arr.get(0);
        int maxEnding = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            maxEnding = Math.max(maxEnding + arr.get(i), arr.get(i));
            maxSum = Math.max(maxSum, maxEnding);
        }
        return maxSum;
    }
}

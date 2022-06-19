import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SubarrayWithGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(isSubarrayWithGivenSum(arr, sum));
        System.out.println(countSubarraysWithGivenSum(arr, sum));
        sc.close();
    }

    private static boolean isSubarrayWithGivenSum(int[] arr, int sum) {
        var hs = new HashSet<Integer>(arr.length);
        int prefixSum = 0;

        for (var item : arr) {
            prefixSum += item;
            if(prefixSum == sum) return true;
            if(hs.contains(prefixSum - sum)) return true;
            hs.add(prefixSum);
        }

        return false;
    }

    private static int countSubarraysWithGivenSum(int[] arr, int sum) {
        var hm = new HashMap<Integer, Integer>();
        int count = 0;
        int prefixSum = 0;

        for (var item : arr) {
            prefixSum += item;
            if(prefixSum == sum) ++count;
            count += hm.getOrDefault(prefixSum - sum, 0);     //If prefixSum-sum is not in HM, this getOrDefault will give 0 
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}

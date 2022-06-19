import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();

        System.out.println(longestSubarrayWithGivenSum(arr, sum));
        sc.close();
    }

    private static int longestSubarrayWithGivenSum(int[] arr, int sum) {
        var hm =  new HashMap<Integer, Integer>();
        int maxLen = 0, currLen = 0, prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if(prefixSum == sum) currLen = i+1;
            else if(hm.containsKey(prefixSum - sum)) currLen = i - hm.get(prefixSum - sum);
            
            if(! hm.containsKey(prefixSum)) hm.put(prefixSum, i);

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}

// Given an array with non-negative values, task is to determine if there exists a subarray with sum equal to the given sum

import java.util.ArrayList;
import java.util.Scanner;

public class SubarrayWithAGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int sum = sc.nextInt();
        System.out.println(checkSubarrayWithAGivenSum(arr, sum));
        sc.close();
    }

    public static boolean checkSubarrayWithAGivenSum(ArrayList<Integer> arr, int sum) {
        int i = 0, j = 1, n = arr.size();
        int currsum = arr.get(0);

        while (j < n) {
            while(currsum > sum) {
                currsum -= arr.get(i);
                i++;
            }
            if(currsum == sum) return true;
            currsum += arr.get(j);
            j++;
        }

        return false;
    }
}

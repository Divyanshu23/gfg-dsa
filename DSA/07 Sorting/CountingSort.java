// Counting Sort (Non Comparison Based Algo)
// Sorts the input array in 0(N+k) where array has elements in range (0,k-1) A.S.C = 0(N+k).
// This algo is useful only when k is linear in terms of n i.e. n/2, n/3, 2*n or something.
// Stable Sorting

import java.util.Scanner;

public class CountingSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        countingSort(arr, k);
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void countingSort(int[] arr, int k) {
        int[] count = new int[k];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] += count[i-1];    // Modify count array to count the number of elements <= to current index element
        }

        int[] out = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {     // We start from end to maintain stability
            out[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }

        for (int j = 0; j < out.length; j++) {
            arr[j] = out[j];
        }
    }
}

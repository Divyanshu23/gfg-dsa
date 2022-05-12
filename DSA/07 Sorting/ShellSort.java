// Shell Sort (Optimized Insertion Sort)
// Does less comparisons as compared to Insetion SOrt

import java.util.Scanner;

public class ShellSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        shellSort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void shellSort(int[] arr) {
        int n = arr.length;
        int key,j;
        for (int gap = n/2; gap > 0; gap--) {
            for (int i = gap; i < n; i++) {
                key = arr[i];
                j = i-gap;
                while (j >= 0 && key < arr[j]) {
                    arr[j+gap] = arr[j];
                    j = j - gap;
                }
                arr[j+gap] = key;
            }
        }
    }
}

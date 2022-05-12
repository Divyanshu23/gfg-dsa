import java.util.Scanner;

// Best algo for small size arrays.
// theta(N^2) in worst case when the array is reverse sorted.
// theta(N) when array is sorted.
// In general, it is a O(N^2 algo)
// Inplace and Stable

public class InsertionSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        insertion(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void insertion(int[] arr) {
        int j, key;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i-1;
            while (j >= 0 && key < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}

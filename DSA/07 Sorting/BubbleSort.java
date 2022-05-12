import java.util.Scanner;

// Bubble Sort
// thtea(N^2), Inplace, Stable

public class BubbleSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        bubble(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void bubble(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j,j+1);
                    swapped = true;
                }
            }
            if(!swapped) return;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

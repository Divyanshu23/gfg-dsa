import java.util.Scanner;

//  theta(n^2), inplace, unstable, less memory write (Cycle Sort has even smaller memory write)

public class SelectionSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        selection(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        sc.close();
    }
    public static void selection(int[] arr) {
        int currMin;
        for (int i = 0; i < arr.length-1; i++) {
            currMin = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[currMin]) currMin = j;
            }
            swap(arr, i, currMin);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

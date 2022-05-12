import java.util.Scanner;

public class MergeSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        mergeSort(arr, 0, arr.length-1);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println();
        sc.close();
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if(low < high) {
            int mid = low + (high - low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            mergeEfficient(arr, low, mid, high);
        }
    }

    public static void mergeEfficient(int[] arr, int low, int mid, int high) {
        int k = low, i = low, j = mid+1;
        int ele = Math.max(arr[mid], arr[high]) + 1;
        if(ele == 0) ele++;

        while (i <= mid && j <= high) {
            if((arr[i] % ele) <= (arr[j] % ele)) {
                arr[k] += (arr[i]%ele)*ele;
                k++;
                i++;
            } else {
                arr[k] += (arr[j]%ele)*ele;
                k++;
                j++;
            }
        }

        while (i <= mid) {
            arr[k] += (arr[i]%ele)*ele;
            k++;
            i++;
        }

        while (j <= high) {
            arr[k] += (arr[j]%ele)*ele;
            k++;
            j++;
        }

        for (int l = low; l <= high; l++) {
            arr[l] = arr[l]/ele;
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid-low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < L.length; i++) {
            L[i] = arr[low + i];
        }

        for (int i = 0; i < R.length; i++) {
            R[i] = arr[mid+1+i];
        }

        int k = low;
        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
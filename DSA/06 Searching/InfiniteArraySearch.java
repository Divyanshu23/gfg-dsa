import java.util.ArrayList;
import java.util.Scanner;

public class InfiniteArraySearch {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(infiniteArraySearch(arr, k));
        sc.close();
    }

    public static int infiniteArraySearch(int[] arr, int k) {
        if(arr[0] == k) return 0;

        int low = 1;

        while (arr[low] < k) {
            low *= 2;
        }

        if(arr[low] == k) return low;
        return binarySearch(arr, k, low/2, low);
    }

    public static int binarySearch(int[] arr, int k, int low, int high) {
        int mid;

        while (low <= high) {
            mid = low + (high - low) / 2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] < k) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
import java.util.Scanner;

public class SearchSortedRotated {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(searchSortedRotated(arr,k));
        sc.close();
    }

    public static int searchSortedRotated(int[] arr, int k) {
        int low = 0, high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            if(arr[mid] == k) return mid;
            else {
                if(arr[mid] >= arr[low] && arr[mid] >= arr[high]) {
                    if(arr[mid] > k && arr[low] <= k) high = mid-1;
                    else low = mid+1;
                } else if(arr[mid] <= arr[high] && arr[mid] <= arr[low]) {
                    if(arr[mid] < k && k <= arr[high]) low = mid+1;
                    else high = mid-1;
                } else {
                    if(arr[mid] < k) low = mid+1;
                    else high = mid-1;
                }
            }
        }
        return -1;
    }
}
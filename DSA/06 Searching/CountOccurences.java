import java.util.Scanner;

public class CountOccurences {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        System.out.println(countOccurences(arr, k));
        sc.close();
    }

    public static int countOccurences(int[] arr, int k) {
        int first = firstOccurence(arr, k);
        return first == -1 ? first : lastOccurence(arr, k) - first + 1;
    }

    public static int firstOccurence(int[] arr, int k) {
        int low = 0; int high = arr.length-1;
        int mid, ans=-1;

        while (low <= high) {
            mid = low + (high - low)/2;
            if(arr[mid] == k) {
                ans = mid;
                high = mid-1;
            } else if(arr[mid] < k) low = mid+1;
            else high = mid-1;
        }

        return ans;
    }

    public static int lastOccurence(int[] arr, int k) {
        int low = 0; int high = arr.length-1;
        int mid, ans=-1;

        while (low <= high) {
            mid = low + (high - low)/2;
            if(arr[mid] == k) {
                ans = mid;
                low = mid+1;
            } else if(arr[mid] < k) low = mid+1;
            else high = mid-1;
        }

        return ans;
    }
}

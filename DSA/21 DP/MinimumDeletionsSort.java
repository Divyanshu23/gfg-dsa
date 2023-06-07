import java.util.Scanner;

public class MinimumDeletionsSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minDeletions(arr));
        sc.close();
    }

    private static int minDeletions(int[] arr) {
        return arr.length - lis(arr);
    }

    private static int lis(int[] arr) {
        int n = arr.length;
        var tail = new int[n];
        int pos = -1;
        tail[++pos] = arr[0];

        int k;
        for (int i = 1; i < n; i++) {
            if(arr[i] > tail[pos]) {
                tail[++pos] = arr[i]; 
            } else {
                k = findCeiling(tail, arr[i], 0, pos);
                tail[k] = arr[i];
            }
        }
        return pos+1;
    }

    private static int findCeiling(int[] arr, int k, int s, int e) {
        int mid;

        int ans = e;
        while (s <= e) {
            mid = s + (e-s)/2;
            if(arr[mid] == k) {
                ans = mid;
                s = mid+1;
            } else if(arr[mid] < k) {
                s = mid+1;
            } else {
                ans = mid;
                e = mid-1;
            }
        }
        return ans;
    }
}

import java.util.Scanner;

public class FirstOccurence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        System.out.println("First index of " + k + " is " + firstOccurence(arr, k));
        sc.close();
    }

    public static int firstOccurence(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int mid;
        int res = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if(arr[mid] == k) {
                res = mid;
                end = mid-1;
            }
            else if(arr[mid] < k) start = mid+1;
            else end = mid-1;
        }
        return res;
    }
}

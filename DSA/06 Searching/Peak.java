import java.util.Scanner;

public class Peak {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(arr[getPeak(arr)]);
        sc.close();
    }

    public static int getPeak(int[] arr) {
        int low = 0, high = arr.length-1;
        int mid;

        while (low <= high) {
            mid = low + (high - low)/2;
            if(low < mid && mid < high) {
                if((arr[mid] >= arr[mid-1]) && (arr[mid] >= arr[mid+1])) return mid;
                else if(arr[mid] < arr[mid-1]) high = mid-1;
                else low = mid+1;
            } else if(low == (high - 1)) {
                if(arr[mid] >= arr[mid+1]) return mid;
                else return mid+1;
            } else return mid;
        }

        return 0;    // Never Reached
    }
}

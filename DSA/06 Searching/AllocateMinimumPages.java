import java.util.Scanner;

public class AllocateMinimumPages {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        sc.close();
    }

    public static int allocateMinimumPages(int[] arr, int k) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i = 0; i < arr.length; i++) {
            high += arr[i];
            low = Math.max(low, arr[i]);
        }

        int mid, students, ans = 0;
        while (low <= high) {
            mid = low + (high - low)/2;
            students = getStudents(arr, mid);
            if(students <= k) {
                high = mid-1;
            }
            else low = mid+1;
        }

        return ans;
    }

    public static int getStudents(int[] arr, int maxPages)  {
        int curr = 0, students = 0;
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if(curr > maxPages) {
                curr = arr[i];
                students++;
            }
        }
        return students + 1;
    }
}
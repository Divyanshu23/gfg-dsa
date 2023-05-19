import java.util.Scanner;

public class BinarySearch {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(binarySearchIterative(arr, k));
        System.out.println(binarySearchRecursive(arr, k, 0, arr.length-1));
        sc.close();
    }   
    
    public static int binarySearchIterative(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if(arr[mid] == k) return mid;
            else if(arr[mid] < k) start = mid+1;
            else end = mid-1;
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] arr, int k, int start, int end) {
        if(start > end) return -1;

        int mid = start + (end - start)/2;
        if(arr[mid] == k) return mid;
        else if(arr[mid] < k) return binarySearchRecursive(arr, k, mid+1, end);
        else return binarySearchRecursive(arr, k, start, mid-1);
    }
}
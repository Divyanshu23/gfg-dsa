import java.util.Scanner;

public class PairWithGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();
        System.out.println(checkPairs(arr, sum, 0, arr.length-1));
        System.out.println(checkTriplets(arr, sum));
        sc.close();
    }

    public static boolean checkPairs(int[] arr, int sum, int low, int high) {
        while (low < high) {
            if(arr[low] + arr[high] == sum) return true;
            else if(arr[low] + arr[high] < sum) low++;
            else high--;
        }
        return false;
    }
    
    public static boolean checkTriplets(int[] arr, int sum) {
        for (int i = 0; i < arr.length-2; i++) {
            if(checkPairs(arr, sum - arr[i], i+1, arr.length-1)) return true;
        }
        return false;
    }
}
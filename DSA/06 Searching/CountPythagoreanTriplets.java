import java.util.Scanner;

public class CountPythagoreanTriplets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countPythagoreanTriplets(arr));
        sc.close();
    }

    public static int countPythagoreanTriplets(int[] arr) {
        int count = 0;
        for (int i = arr.length - 1; i >= 2; i--) {
            count += CountPairs(arr, arr[i], 0, i-1);
        }
        return count;
    }

    public static int CountPairs(int[] arr, int c, int low, int high) {
        int count = 0;
        int il, ih;

        while (low < high) {
            if(arr[low]*arr[low] + arr[high]*arr[high] == c*c) {
                il = low; ih = high;
                while(arr[low] == arr[il] && low != ih) {
                    ++low;
                }
                while (arr[high] == arr[ih] && high != il ) {
                    --high;
                }

                if(arr[il] == arr[ih]) count += ((low - high + 1)*(low - high)) / 2;
                else count += (low - il)*(ih - high);
            } else if(arr[low]*arr[low] + arr[high]*arr[high] < c*c) ++low;
            else --high;
        }
        return count;
    }
}

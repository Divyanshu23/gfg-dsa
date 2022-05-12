import java.util.Scanner;

public class CountTripletsWithGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = sc.nextInt();
        System.out.println(countTriplets(arr, sum));
        sc.close();
    }

    public static int countTriplets(int[] arr, int sum) {
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            count += countPairs(arr, sum - arr[i], i+1, arr.length - 1);
        }

        return count;
    }

    public static int countPairs(int[] arr, int sum, int low, int high) {
        int count = 0;
        int il, ih;

        while (low < high) {
            if(arr[low] + arr[high] == sum) {
                il = low; ih = high;
                while(arr[low] == arr[il] && low != ih) {
                    ++low;
                }
                while (arr[high] == arr[ih] && high != il ) {
                    --high;
                }

                if(arr[il] == arr[ih]) count += ((low - high + 1)*(low - high)) / 2;
                else count += (low - il)*(ih - high);
            } else if(arr[low] + arr[high] < sum) ++low;
            else --high;
        }
        return count;
    }
}

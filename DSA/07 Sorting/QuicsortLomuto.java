// Unstable (Naive version is stable), inplace
// Worst Case T.C = O(n**2) and S.C = O(N)
// Best and avg case T.C = O(n*log(n)) and S.C = O(log(n))

// Quick Sort is considered better than Merge Sort even if its worst case is O(n**2) because:-
// a) In-Place
// b) Cache Friendly
// c) Avg case if O(n*log(n))
// d) Tail Recursive

import java.util.Random;
import java.util.Scanner;

public class QuicsortLomuto {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        quicksortLomuto(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quicksortLomuto(int[] arr, int l, int h) {
        while (l < h) {
            int p = lomutoPartition(arr, l, h);
            if((p - l) <= (h-p)) {
                quicksortLomuto(arr, l, p-1);
                l = p+1;
            } else {
                quicksortLomuto(arr, p+1, h);
                h = p-1;
            }
        }
    }

    public static int lomutoPartition(int[] arr, int l, int h) {

        var rand = new Random();
        int p = rand.nextInt(h - l + 1) + l;
        swap(arr, p, h);

        int i = l-1;
        for (int j = l; j <= h-1; j++) {
            if(arr[j] < arr[h]) {
                ++i;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, h);
        return i+1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

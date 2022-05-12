// Unstable (Naive version is stable), inplace
// Worst Case T.C = O(n**2) and S.C = O(N)
// Best and avg case T.C = O(n*log(n)) and S.C = O(log(n))

// Quick Sort is considered better than Merge Sort even if its worst case is O(n**2) because:-
// a) In-Place
// b) Cache Friendly
// c) Avg case if O(n*log(n))
// d) Tail Recursive

import java.util.Scanner;
import java.util.Random;

public class QuicksortHoare {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        quicksortHoare(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quicksortHoare(int[] arr, int l, int h) {
        while (l < h) {
            int p = hoarePartition(arr, l, h);
            if((p - l + 1) <= (h-p)) {
                quicksortHoare(arr, l, p);
                l = p+1;
            } else {
                quicksortHoare(arr, p+1, h);
                h = p;
            }
        }
    }

    public static int hoarePartition(int[] arr, int l, int h) {

        var rand = new Random();
        int p = rand.nextInt(h - l + 1) + l;
        swap(arr, p, l);

        int i = l-1;
        int j = h+1;
        int ele = arr[l];

        while (true) {
            do {
                i++;
            } while(arr[i] < ele);

            do {
                j--;
            } while (arr[j] > ele);

            if(i >= j) return j;
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

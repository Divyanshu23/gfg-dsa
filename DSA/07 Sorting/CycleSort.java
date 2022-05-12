// Minimum Memory Writes
// Unstable, inplace
// Worst Case O(N^2)

import java.util.Scanner;

public class CycleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int writes = cycleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Min. Number of Writes to Sort Array: " + writes);
        sc.close();
    }

    public static int cycleSort(int[] arr) {
        int n = arr.length;
        int curr, pos = 0, writes = 0;
        int temp;

        for (int cs = 0; cs < n-1; cs++) {
            curr = arr[cs];
            pos = cs;

            for (int i = cs+1; i < n; i++) {
                if(arr[i] < curr) pos++;
            }

            if(pos == cs) continue;

            while (curr == arr[pos])    // Handle Duplicates
                ++pos;

            curr = arr[pos];
            arr[pos] = arr[cs];
            ++writes;

            while (pos != cs) {
                pos = cs;
                for (int i = cs+1; i < n; i++) {
                    if(arr[i] < curr) ++pos;
                }

                while (curr == arr[pos])
                    ++pos;

                temp = arr[pos];
                arr[pos] = curr;
                curr = temp;
                ++writes;
            }
        }

        return writes;
    }
}
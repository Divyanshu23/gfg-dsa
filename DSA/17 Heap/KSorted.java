// O(n*log(k))

import java.util.PriorityQueue;
import java.util.Scanner;

public class KSorted {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sortKSorted(arr, k);
        for (var item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
        sc.close();
    }

    private static void sortKSorted(int[] arr, int k) {
        var pq = new PriorityQueue<Integer>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        int index = 0;
        for(int i=k+1;i<arr.length;i++) {
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }
    }
}

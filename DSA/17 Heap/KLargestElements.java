import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        kLargest(arr, k);
        sc.close();
    }

    private static void kLargest(int[] arr, int k) {
        var pq = new PriorityQueue<Integer>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < arr.length; i++) {
            if(arr[i] > pq.peek()) {
                pq.poll();
                pq.add(arr[i]);
            }
        }

        for (var item : pq) {
            System.out.print(item +" ");
        }
        System.out.println();
    }
}

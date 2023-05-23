import java.util.*; 

public class MaxOfAllSubarraysOfSizeK {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];

        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        maxSubarraySizeK(arr, n, k);
        sc.close();
    }

    public static void maxSubarraySizeK(int[] arr, int n, int k) {
        var dq = new ArrayDeque<Integer>();
        for(int i=0;i<k;i++) {
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        for(int i=k;i<n;i++) {
            System.out.println(arr[dq.peekFirst()] + " ");

            while(!dq.isEmpty() && dq.peekFirst() <= (i-k)) {
                dq.pollFirst();
            }

            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        System.out.println(arr[dq.peekFirst()] + " ");
    }
}
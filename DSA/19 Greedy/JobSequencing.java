import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new MyPair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new MyPair(sc.nextInt(), sc.nextInt());
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i].deadline + " " + arr[i].profit);
        }
        System.out.println();
        System.out.println(maxProfit(arr));
        sc.close();
    }

    private static int maxProfit(MyPair[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int maxEnding = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxEnding = Math.max(maxEnding, arr[i].deadline);
        }
        var slots = new boolean[maxEnding];

        int res = 0;
        int index;

        for(int i=0;i<n;i++) {
            index = arr[i].deadline-1;
            while(index >= 0 && slots[index])
                index--;
            if(index >= 0 && !slots[index]) {
                slots[index] = true;
                res += arr[i].profit;
            }
        }

        return res;
    }

    private static class MyPair implements Comparable<MyPair> {
        public int deadline;
        public int profit;
        
        public MyPair(int d, int p) {
            deadline = d;
            profit = p;
        }

        @Override
        public int compareTo(MyPair o) {
            return o.profit - this.profit;
        }
    }
}

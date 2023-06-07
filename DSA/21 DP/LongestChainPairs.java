import java.util.Arrays;
import java.util.Scanner;

// Done using DP
// Exactly same as Activity Selection (can be solved using Greedy)

public class LongestChainPairs {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new MyPair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new MyPair(sc.nextInt(), sc.nextInt());
        }
        System.out.println(longestChain(arr));
        sc.close();
    }

    private static int longestChain(MyPair[] arr) {
        Arrays.sort(arr);
        return lis(arr);
    }


    private static int lis(MyPair[] arr) {
        int n = arr.length;
        var tail = new MyPair[n];
        int pos = -1;
        tail[++pos] = arr[0];

        int k;
        for (int i = 1; i < n; i++) {
            if(arr[i].ele1 > tail[pos].ele2) {
                tail[++pos] = arr[i]; 
            } else {
                k = findCeiling(tail, arr[i].ele1, 0, pos);
                if(tail[k].ele2 >= arr[i].ele1 && tail[k].ele2 >= arr[i].ele2)
                    tail[k] = arr[i];
            }
        }
        return pos+1;
    }

    private static int findCeiling(MyPair[] arr, int k, int s, int e) {
        int mid;

        int ans = e;
        while (s <= e) {
            mid = s + (e-s)/2;
            if(arr[mid].ele2 == k) {
                ans = mid;
                s = mid+1;
            } else if(arr[mid].ele2 < k) {
                s = mid+1;
            } else {
                ans = mid;
                e = mid-1;
            }
        }
        return ans;
    }

    private static class MyPair implements Comparable<MyPair> {
        int ele1;
        int ele2;

        public MyPair(int ele1, int ele2) {
            this.ele1 = ele1;
            this.ele2 = ele2;
        }
        
        @Override
        public int compareTo(MyPair obj) {
            if(this.ele1 < obj.ele1)
                return -1;
            else if(this.ele1 > obj.ele1)
                return 1;
            else
                return this.ele2 - obj.ele2;
        }
    }
}

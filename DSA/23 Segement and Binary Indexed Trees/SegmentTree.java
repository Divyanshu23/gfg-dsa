import java.util.Arrays;
import java.util.Scanner;

// For an array of size n, number of nodes in Segment tree = 2*(2^Ceil(Log2(n)))-1
// Number of nodes is upper bounded by 4n

// Sparse Table method can be used for Range Minima, Maxima and GCD as they all are idempotent operations
// Not for Range Sum

public class SegmentTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ceil = (int)Math.ceil(Math.log(n)/Math.log(2));
        var sTree = new int[2*(int)Math.pow(2,ceil)-1];
        Arrays.fill(sTree, -1);
        buildTree(arr, sTree, 0, n-1, 0);
        System.out.println(rangeQuery(sTree, 0, 0, n-1, 1, 3));  // Pass n >= 4
        updateQuery(arr, sTree, 0, 0, n-1, 2, 100);
        arr[2] = 100;
        System.out.println(rangeQuery(sTree, 0, 0, n-1, 1, 3));
        sc.close();
    }

    private static int buildTree(int[] arr, int[] sTree, int ss, int se, int si) {          // Theta(n)
        if(ss == se) {
            sTree[si] = arr[ss];
            return sTree[si];
        }

        int left = buildTree(arr, sTree, ss, (ss+se)/2, 2*si+1);
        int right = buildTree(arr, sTree, (ss+se)/2+1, se, 2*si+2);
        sTree[si] = left+right;
        return sTree[si];
    }

    private static int rangeQuery(int[] sTree, int si, int ss, int se, int qs, int qe) {  // O(Log(n))
        if(qs > se || qe < ss) return 0;
        if(qs <= ss && qe >= se) return sTree[si];

        return rangeQuery(sTree, 2*si+1, ss, (ss+se)/2, qs, qe) + 
                            rangeQuery(sTree, 2*si+2, (ss+se)/2+1, se, qs, qe);
    }

    private static void updateQuery(int arr[], int[] sTree, int si, int ss, int se, int qi, int val) {
        if(qi < ss || qi > se) return;                                                     // O(Log(n))

        int diff = val - arr[qi];
        sTree[si] += diff;

        if(ss < se) {
            updateQuery(arr, sTree, 2*si+1, ss, (ss+se)/2, qi, val);
            updateQuery(arr, sTree, 2*si+2, (ss+se)/2+1, se, qi, val);
        }
    }
}

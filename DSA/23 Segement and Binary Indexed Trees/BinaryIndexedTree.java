import java.util.Scanner;

public class BinaryIndexedTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        var bITree = new int[n+1];
        buildTree(arr, bITree);
        System.out.println(rangeQuery(bITree, 5));
        sc.close();
    }

    private static void buildTree(int[] arr, int[] bITree) {
        for (int i = 0; i < arr.length; i++) {
            updateQuery(bITree, i, arr, arr[i]);
        }
    }

    private static int rangeQuery(int[] bITree, int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += bITree[i];
            i = i - (i & (-i));
        }
        return sum;
    }

    private static void updateQuery(int[] bITree, int i, int[] arr, int val) {
        int diff = val - 0;
        arr[i] = val;
        i++;
        while (i < bITree.length) {
            bITree[i] += diff;
            i = i + (i & (-i));
        }
    }
}

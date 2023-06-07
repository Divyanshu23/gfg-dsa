import java.util.Scanner;

public class DistinctRowsBinaryMatrix {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        var mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        root = new TrieNode();
        System.out.println(countDistinct(mat));
        sc.close();
    }

    private static TrieNode root;

    private static int countDistinct(int[][] mat) {
        int res = 0;
        for (int i = 0; i < mat.length; i++) {
            if(insert(mat[i]))
                res++;
        }
        return res;
    }


    private static boolean insert(int[] arr) {
        int n = arr.length;
        var curr = root;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(curr.child[arr[i]] == null) {
                curr.child[arr[i]] = new TrieNode();
                flag = true;
            }
            curr = curr.child[arr[i]];
        }
        return flag;
    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[2];
    }
}

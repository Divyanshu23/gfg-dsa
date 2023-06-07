import java.util.Scanner;

public class PreOrderToBST {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var pre = new int[n];
        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }

        Node root = constructBST(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
        sc.close();
    }
    
    private static int i = 0;
    private static Node constructBST(int[] pre, int min, int max) {
        if(i < pre.length) {
            if(pre[i] > min && pre[i] < max) {
                var root = new Node(pre[i]);
                i++;
                root.left = constructBST(pre, min, root.val);
                root.right = constructBST(pre, root.val, max);
                return root;
            }
            return null;
        }
        return null;
    }

    private static class Node {
        Node left;
        Node right;
        int val;
    
        public Node(int val) {
            this.val = val;
        }
    }
}
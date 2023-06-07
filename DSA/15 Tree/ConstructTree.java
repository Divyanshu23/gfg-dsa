// To construct a tree, inorder traveral is necessarily required
// Next can be preorder or postorder traversal.

import java.util.Scanner;

public class ConstructTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var in = new int[n];
        var pre = new int[n];
        var post = new int[n];

        for (int i = 0; i < n; i++) {
            in[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            pre[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            post[i] = sc.nextInt();
        }

        var root = constuctFromPre(in, pre, 0, n-1);
        traverseTree(root);
        System.out.println();
        end = n-1;
        root = constuctFromPost(in, post, 0, n-1);
        traverseTree(root);
        System.out.println();
        sc.close();
    }

    private static int start = 0;
    private static Node constuctFromPre(int[] in, int [] pre, int s, int e) {
        if(e-s < 0)
            return null;

        var root = new Node(pre[start++]);
        int i;
        for (i = s; i <= e; i++) {
            if(in[i] == root.val)
                break;
        }
        root.left = constuctFromPre(in, pre, s,i-1);
        root.right = constuctFromPre(in,pre, i+1,e);
        return root;
    }

    private static int end;
    private static Node constuctFromPost(int[] in, int [] post, int s, int e) {
        if(e-s < 0)
            return null;

        var root = new Node(post[end--]);
        int i;
        for (i = s; i <= e; i++) {
            if(in[i] == root.val)
                break;
        }
        root.right = constuctFromPost(in,post, i+1,e);
        root.left = constuctFromPost(in, post, s,i-1);
        return root;
    }

    private static void traverseTree(Node root) {
        if(root == null) return;
        traverseTree(root.left);
        System.out.print(root.val + " ");
        traverseTree(root.right);
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

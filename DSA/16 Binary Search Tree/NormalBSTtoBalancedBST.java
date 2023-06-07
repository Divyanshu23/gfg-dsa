import java.util.ArrayDeque;
import java.util.ArrayList;

public class NormalBSTtoBalancedBST {
    public static void main (String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.left.left = new Node(6);
        root.left.left.left.left = new Node(5);
        root = balanceBST(root);
        preOrder(root);
        System.out.println();
    }

    private static Node balanceBST(Node root) {
        var arr = new ArrayList<Integer>();
        Node curr = root;
        var st = new ArrayDeque<Node>();

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            arr.add(curr.val);
            curr = curr.right;
        }
        return buildTreeUtil(arr, 0, arr.size()-1);
    }

    private static Node buildTreeUtil(ArrayList<Integer> arr, int l, int h) {
        if(l > h) return null;

        int mid = l + (h-l)/2;
        Node root = new Node(arr.get(mid));
        root.left = buildTreeUtil(arr, l, mid-1);
        root.right = buildTreeUtil(arr, mid+1, h);
        return root;
    }

    private static void preOrder(Node root)
    {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
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
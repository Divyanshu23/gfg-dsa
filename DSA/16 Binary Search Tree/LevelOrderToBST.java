import java.util.ArrayDeque;

public class LevelOrderToBST {
    public static void main (String[] args) {
        int[] arr = {7,4,12,3,6,8,1,5,10};
        var root = constructBST(arr);
        traverse(root);
    }

    private static void traverse(Node root) {
        if(root == null) return;
        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);
    }

    private static Node constructBST(int[] arr) {
        int n = arr.length;
        var q = new ArrayDeque<Triplet>();
        Node root = new Node(arr[0]);
        q.offer(new Triplet(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        
        Triplet curr = null;
        int i = 1;
        while(i < n) {
            curr = q.poll();
            
            if(arr[i] < curr.root.val && arr[i] > curr.min) {
                curr.root.left = new Node(arr[i]);
                i++;
                q.offer(new Triplet(curr.root.left, curr.min, curr.root.val));
            }
            
            if(i < n && arr[i] > curr.root.val && arr[i] < curr.max) {
                curr.root.right = new Node(arr[i]);
                i++;
                q.offer(new Triplet(curr.root.right, curr.root.val, curr.max));
            }
        }
        
        return root;
    }

    private static class Triplet {
        public Node root;
        public int min;
        public int max;
        
        public Triplet(Node root, int min, int max) {
            this.root = root;
            this.min = min;
            this.max = max;
        }
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
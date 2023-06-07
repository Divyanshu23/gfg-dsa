public class MaxDifferenceBetweenNode {

    public static void main (String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(1);
        System.out.println(maxDiff(root));
    }

    private static int diff = Integer.MIN_VALUE;
    private static int maxDiff(Node root)
    {
        util(root);
        return diff;
    }
    
    private static int util(Node root) {
        if(root == null)
            return 0;
            
        if(root.left != null) {
            int left = maxDiff(root.left);
            if(root.right != null) {
                int right = maxDiff(root.right);
                diff = Math.max(diff, root.data - Math.min(left, right));
                return Math.min(root.data, Math.min(left, right));
            } else {
                diff = Math.max(diff, root.data - left);
                return Math.min(root.data, left);
            }
        } else if(root.right != null) {
            int right = maxDiff(root.right);
            if(root.left != null) {
                int left = maxDiff(root.left);
                diff = Math.max(diff, root.data - Math.min(left, right));
                return Integer.min(root.data, Integer.min(left, right));
            } else {
                diff = Math.max(diff, root.data - right);
                return Math.min(root.data, right);
            }
        } else {
            return root.data;
        }
    }
    private static class Node {
        Node left;
        Node right;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }
}

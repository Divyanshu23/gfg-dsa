public class MaxPathSum {
    public static void main (String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.left=new Node(80);
        findMaxSum(root);
        System.out.println("Max Sum: " + maxi);
    }

    private static int maxi = Integer.MIN_VALUE;

    private static int findMaxSum(MaxPathSum.Node root) {
        if(root == null) return 0;
        
        int left = Math.max(0, findMaxSum(root.left));
        int right = Math.max(0, findMaxSum(root.right));
        
        maxi = Math.max(maxi, left+right+root.val);
        return root.val + Math.max(left, right);
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

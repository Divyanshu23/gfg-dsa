import java.util.HashMap;

public class MaxSumNonAdjacent {
    public static void main (String[] args) {
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.left=new Node(80);
        System.out.println(getMaxSum(root));
    }

    private static HashMap<Node, Integer> hm = new HashMap<>();

    private static int getMaxSum(Node root) {
        if(root == null) return 0;
        if(hm.containsKey(root))
            return hm.get(root);
            
            
        int left = 0, right = 0;
        if(root.left != null) {
            left = getMaxSum(root.left.left) + getMaxSum(root.left.right);
        }
        
        if(root.right != null) {
            right = getMaxSum(root.right.left) + getMaxSum(root.right.right);
        }
        int sum1 = left + right + root.val;
        
        int sum2 = getMaxSum(root.left) + getMaxSum(root.right);
        var res = Math.max(sum1, sum2);
        hm.put(root, res);
        return res;
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

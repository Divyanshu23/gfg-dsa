import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String args[])
    {
        Node root = new Node(10);  
        root.left = new Node(8);  
        root.right = new Node(20);  
        root.left.left = new Node(4);
        root.left.right = new Node(9);
        root.right.left = new Node(11);
        root.right.right = new Node(30);  
        root.right.right.left = new Node(25);
        
        int sum=33;
        
        HashSet<Integer> s=new HashSet<>();    
        System.out.print(isPairSum(root,sum,s));
    }
    
    private static boolean isPairSum(Node root, int sum, HashSet<Integer> s) {
        if(root == null) return false;
        if(isPairSum(root.left, sum, s)) return true;
        if(s.contains(sum - root.val)) return true;
        else s.add(root.val);
        return isPairSum(root, sum, s);
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

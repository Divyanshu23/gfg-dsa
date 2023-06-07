import java.util.Scanner;

public class FoldableTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.right.right=new Node(80);
        System.out.println(isFoldable(root));
        sc.close();
    }


    private static boolean isFoldable(Node root) {
        if(root == null) return true;
	    return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node r1, Node r2) {
        if(r1 == null && r2 == null) return true;
	    if(r1 == null || r2 == null) return false;
	    
	    if(isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left))
	        return true;
	    else 
            return false;
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

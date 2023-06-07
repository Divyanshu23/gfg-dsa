public class Search {
    public static void main(String args[]) 
    { 
        Node root=new Node(15);
    	root.left=new Node(5);
    	root.left.left=new Node(3);
    	root.right=new Node(20);
    	root.right.left=new Node(18);
    	root.right.left.left=new Node(16);
    	root.right.right=new Node(80);
    	int x=16;
        System.out.println(searchRecursive(root, x));
        System.out.println(searchIterative(root, x));
    }

    private static boolean searchIterative(Node root, int x) {
        while (root != null) {
            if(root.val == x) return true;
            else if(x < root.val) root = root.left;
            else root = root.right;
        }
        return false;
    }

    private static boolean searchRecursive(Node root, int x) {
        if(root == null) return false;
        if(x == root.val) return true;
        else if(x < root.val) return searchRecursive(root.left, x);
        else return searchRecursive(root.right, x);
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

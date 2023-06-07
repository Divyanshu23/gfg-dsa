public class Ceil {
    public static void main(String args[]) { 
        Node root=new Node(15);
    	root.left=new Node(5);
    	root.left.left=new Node(3);
    	root.right=new Node(20);
    	root.right.left=new Node(18);
    	root.right.left.left=new Node(16);
    	root.right.right=new Node(80);
    	int x=17;
        Node res = ceil(root, x);
        System.out.println(res != null ? res.val : "null");
    }

    private static Node ceil(Node root, int x) {
        Node res = null;

        while (root != null) {
            if(x < root.val) {
                res = root;
                root = root.left;
            } else if(x > root.val) 
                root = root.right;
            else {
                res = root;
                break;
            }
        }
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

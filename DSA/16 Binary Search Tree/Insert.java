public class Insert {
    public static void main(String args[]) {
        Node root=new Node(10);
    	root.left=new Node(5);
    	root.right=new Node(15);
    	root.right.left=new Node(12);
    	root.right.right=new Node(18);
    	int x=20;
    	
        Node root1 = insertRecursive(root, x);
        Node root2 = insertIterative(root, x);

        traverse(root1);
        System.out.println();
        traverse(root2);
    }

    private static void traverse(Node root) {
        if(root == null) return;
        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
        System.out.println();
    }

    private static Node insertIterative(Node root, int x) {
        Node parent = null;
        Node curr = root;

        while (curr != null) {
            parent = curr;
            if(curr.val == x) return root;
            else if(x < curr.val) curr = curr.left;
            else curr = curr.right;
        }

        if(parent == null) {
            parent = new Node(x);
        } else {
            if(x < parent.val) parent.left = new Node(x);
            else parent.right = new Node(x);
        }
        if(root == null) root = parent;

        return root;
    }

    private static Node insertRecursive(Node root, int x) {
        if(root == null) {
            return new Node(x);
        } else if(x < root.val) {
            root.left = insertRecursive(root.left, x);
        } else
            root.right = insertRecursive(root.right, x);

        return root;
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
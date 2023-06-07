public class Delete {
    public static void main(String args[]) 
    { 
        Node root=new Node(10);
    	root.left=new Node(5);
    	root.right=new Node(15);
    	root.right.left=new Node(12);
    	root.right.right=new Node(18);
    	int x=15;
    	
        traverse(root);
        System.out.println();
    	root=delete(root,x);
	    traverse(root);
        System.out.println();
    }

    private static void traverse(Node root) {
        if(root == null) return;
        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
    }

    private static Node delete(Node root, int x) {
        if(root == null) return root;
        if(x < root.val) {
            root.left = delete(root.left, x);
        } else if(x > root.val) {
            root.right = delete(root.right, x);
        } else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                root.right = findInorderSuccessorAndRemove(root.right);
                successor.left = root.left;
                successor.right = root.right;
                root = successor;
            }
        }
        return root;
    }

    private static Node successor = null;

    private static Node findInorderSuccessorAndRemove(Node root) {
        if(root.left == null) {
            successor = root;
            return root.right;
        } else {
            root.left = findInorderSuccessorAndRemove(root.left);
            return root;
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

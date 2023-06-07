public class FixBST {
    public static void main(String args[])
    {
        Node root = new Node(18);  
        root.left = new Node(60);  
        root.right = new Node(70);  
        root.left.left = new Node(4);  
        root.right.left = new Node(8);
        root.right.right = new Node(80);
        fixBST(root);
        traverse(root);
        System.out.println();
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        traverse(root);
        System.out.println();
    }

    private static void traverse(Node root) {
        if(root == null) return;
        traverse(root.left);
        System.out.print(root.val + " ");
        traverse(root.right);
    }

    private static Node prev = null;
    private static Node first = null, second = null;
    private static void fixBST(Node root) {
        if(root == null) return;
        if(root.left == null && prev == null) {
            prev = root;
            fixBST(root.right);
        }
    
        fixBST(root.left);
        if(root.val < prev.val) {
            if(first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        fixBST(root.right);
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

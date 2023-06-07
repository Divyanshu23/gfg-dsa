public class ConvertBTtoDLL {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(5);
        root.left.right = new Node(7);
        root.right.left = new Node(9);
        root.left.left.left = new Node(5);
        root.left.left.right = new Node(5);
        root.left.right.left = new Node(9);
        root.left.right.right = new Node(2);
        root.right.left.left = new Node(10);

        traverseTree(root);
        System.out.println();
        var head = BTToDLL(root);
        traverseList(head);
    }

    private static Node tail = null;

    public static Node BTToDLL(Node root){
        if(root==null)return root;
        
        Node head=BTToDLL(root.left);
        if(tail==null){head=root;}
        else{
            root.left=tail;
            tail.right=root;
        }
        tail=root;
        BTToDLL(root.right);
        return head;
    }

    private static void traverseTree(Node root) {
        if (root == null)
            return;
        traverseTree(root.left);
        System.out.print(root.val + " ");
        traverseTree(root.right);
    }

    private static void traverseList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
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

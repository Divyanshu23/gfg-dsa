import java.util.Scanner;

public class CountNodesCompleteTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.left=new Node(80);
        System.out.println(countNodes(root));
        sc.close();
    }

    private static int countNodes(Node root) {
        if(root == null) return 0;
        int left = 0, right = 0;
        Node curr = root;

        while (curr != null) {
            left++;
            curr = curr.left;
        }

        curr = root;
        while (curr != null) {
            right++;
            curr = curr.right;
        }

        if(left == right) return (int)Math.pow(2, left) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
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

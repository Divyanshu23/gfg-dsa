import java.util.ArrayDeque;
import java.util.Scanner;

public class LeftView {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.right.right=new Node(80);
        printLeftView(root);
        sc.close();
    }

    public static void printLeftView(Node root) {
        if(root == null) return;

        var dq = new ArrayDeque<Node>();
        dq.offerLast(root);
        int count;
        Node curr;

        while (!dq.isEmpty()) {
            count = dq.size();
            for (int i = 0; i < count; i++) {
                curr = dq.pollFirst();
                if(count == 0) {
                    System.out.print(curr.val + " ");
                }
                if(curr.left != null) {
                    dq.offerLast(curr.left);
                }
                if(curr.right != null) {
                    dq.offerLast(curr.right);
                }
            }
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
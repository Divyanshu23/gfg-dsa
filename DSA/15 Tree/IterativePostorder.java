import java.util.ArrayDeque;
import java.util.Scanner;

public class IterativePostorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
        root.left.left.left = new Node(70);
        root.left.left.right = new Node(80);
    	root.right.left=new Node(60);
        iterativePostorder(root);
        sc.close();
    }

    private static void iterativePostorder(Node root) {
        var st = new ArrayDeque<Node>();
        var curr = root;
        Node pre = null;

        while (curr != null || !st.isEmpty()) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.peek();
            if(curr.right == null || curr.right == pre) {
                System.out.println(curr.val);
                st.pop();
                pre = curr;
                curr = null;
            } else {
                curr = curr.right;
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

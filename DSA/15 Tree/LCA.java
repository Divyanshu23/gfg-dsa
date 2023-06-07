import java.util.ArrayDeque;
import java.util.Scanner;

public class LCA {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.left=new Node(80);
        int val1 = 70;
        int val2 = 80;
        Node lca = getLCA(root, val1, val2);
        System.out.println(lca.val);
        System.out.println(getLCAEfficient(root, val1, val2).val);
        sc.close();
    }

    private static Node getLCAEfficient(Node root, int val1, int val2) {
        if(root == null) return null;

        if(root.val == val1 || root.val == val2) return root;

        var left = getLCAEfficient(root.left, val1, val2);
        var right = getLCAEfficient(root.right, val1, val2);

        if(left != null && right != null) return root;
        else if(left != null) return left;
        else return right;
    }

    private static ArrayDeque<Node> s1 = new ArrayDeque<>();
    private static ArrayDeque<Node> s2 = new ArrayDeque<>();

    private static boolean val1Flag = false;
    private static boolean val2Flag = false;

    private static Node getLCA(Node root, int val1, int val2) {
        tracePath(root, val1, val2);
        if(s1.size() <= s2.size()) {
            while (s2.size() != s1.size()) {
                s2.pop();
            }
        } else {
            while(s1.size() != s2.size()) {
                s1.pop();
            }
        }

        while (s1.peek() != s2.peek()) {
            s1.pop();
            s2.pop();
        }

        return s1.peek();
    }

    private static void tracePath(Node root, int val1, int val2) {
        if(root == null) return;

        if(!val1Flag) {
            s1.push(root);
            if(root.val == val1) {
                val1Flag = true;
            }
        }

        if(!val2Flag) {
            s2.push(root);
            if(root.val == val2) {
                val2Flag = true;
            }
        }

        if(!val1Flag || !val2Flag) 
            tracePath(root.left, val1, val2);
        if(!val1Flag || !val2Flag)
            tracePath(root.right, val1, val2);

        if(!val1Flag) {
            s1.pop();
        }
        if(!val2Flag) {
            s2.pop();
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

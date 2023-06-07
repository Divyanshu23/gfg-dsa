import java.util.Scanner;

public class Diameter {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.right.right=new Node(80);
        getDiameter(root);
        System.out.println(diameter);
        sc.close();
    }

    private static int getDiameter(Node root) {
        if(root == null) return 0;

        int left = getDiameter(root.left);
        int right = getDiameter(root.right);

        diameter = Math.max(diameter, left+right+1);
        return Math.max(left, right)+1;
    }

    private static int diameter = 0;
    
    private static class Node {
        Node left;
        Node right;
        int val;
    
        public Node(int val) {
            this.val = val;
        }
    }
}

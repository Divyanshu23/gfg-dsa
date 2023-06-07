import java.util.Scanner;

public class DistanceBetweenNodes {
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
        var lca = getLCAEfficient(root, val1, val2);
        var dist1 = getDistance(lca, val1);
        var dist2 = getDistance(lca, val2);
        var res = dist1 + dist2 - 1;
        System.out.println(res);
        sc.close();
    }

    private static int getDistance(Node lca, int val) {
        if(lca == null) return -1;
        if(lca.val == val) return 1;

        int left = getDistance(lca.left, val);
        if(left != -1) return 1+left;
        int right = getDistance(lca.right, val);
        if(right != -1) return 1+right;
        return -1;
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

    private static class Node {
        Node left;
        Node right;
        int val;
    
        public Node(int val) {
            this.val = val;
        }
    }
}

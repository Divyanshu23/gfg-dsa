import java.util.Scanner;

public class BurnTree {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.right.right=new Node(80);
        int leaf = sc.nextInt();
        burnTree(root, leaf, new Distance(-1));
        System.out.println(maxTime);
        sc.close();
    }

    private static int maxTime = 0;

    private static int burnTree(Node root, int leaf, Distance dist) {
        if(root == null) return 0;
        if(root.val == leaf) {
            dist.d = 0;
            return 1;
        }

        var distL = new Distance();
        var distR = new Distance();
        int lh = burnTree(root.left, leaf, distL);
        int rh = burnTree(root.right, leaf, distR);

        if(distL.d != -1) {
            dist.d = distL.d + 1;
            maxTime = Math.max(maxTime, dist.d + rh);
        }
        if(distR.d != -1) {
            dist.d = distR.d + 1;
            maxTime = Math.max(maxTime, dist.d + lh);
        }

        return Math.max(lh, rh)+1;
    }

    private static class Distance {
        public int d;
        public Distance(int d) {
            this.d = d;
        }

        public Distance() {
            this.d = -1;
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

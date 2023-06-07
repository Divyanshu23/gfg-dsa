import java.util.Scanner;

public class NodesAtDistanceK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.left.left=new Node(40);
    	root.left.right=new Node(50);
    	root.right.right=new Node(70);
    	root.right.right.right=new Node(80);
    	int k = sc.nextInt();
    	
        nodesAtDistanceK(root,k);
        sc.close();
    }

    public static void nodesAtDistanceK(Node root, int k) {
        if(root == null)
            return;

        if(k == 0)
            System.out.println(root.val);
        else {
            nodesAtDistanceK(root.left, k-1);
            nodesAtDistanceK(root.right, k-1);
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
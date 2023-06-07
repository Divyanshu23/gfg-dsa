import java.util.HashMap;
import java.util.HashSet;

public class NodeAtDistance {
    public static void main (String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println(kDistantfromLeaf(root, 2));

    }

    private static HashSet<Node> hs = new HashSet<>();
    private static HashMap<Integer, Node> hm = new HashMap<>();

    private static int kDistantfromLeaf(Node root, int k){
        util(root, 0, k, hs, hm);
        return hs.size();
    }
    
    private static void util(Node root, int level, int k, HashSet<Node> hs, HashMap<Integer, Node> hm) {
        if(root == null)
            return;
            
        if(root.left == null && root.right == null) {
            if(k > level)
                return;
            
            var node = hm.get(level - k);
            hs.add(node);
            return;
        }
        
        hm.put(level, root);
        util(root.left, level+1, k, hs, hm);
        util(root.right, level+1, k, hs, hm);
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

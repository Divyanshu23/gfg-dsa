import java.util.ArrayList;

public class Serialize {
    public static void main (String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        var serializedTree = new ArrayList<Integer>();
        serialize(root, serializedTree);
        var root2 = deserialize(serializedTree);
        traverseTree(root2);
    }

    private static void serialize(Node root, ArrayList<Integer> serializedTree) {
        if(root == null) {serializedTree.add(-1); return;}
        serializedTree.add(root.val);
        serialize(root.left, serializedTree);
        serialize(root.right, serializedTree);
    }

    private static int index = 0;

    private static Node deserialize(ArrayList<Integer> serializedTree) {
        if(index == serializedTree.size()) return null;

        var val = serializedTree.get(index++);

        if(val == -1) return null;
        var root = new Node(val);
        root.left = deserialize(serializedTree);
        root.right = deserialize(serializedTree);
        return root;
    }

    private static void traverseTree(Node root) {
        if(root == null) return;
        traverseTree(root.left);
        System.out.print(root.val + " ");
        traverseTree(root.right);
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

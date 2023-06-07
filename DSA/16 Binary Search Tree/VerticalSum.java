import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void main(String args[])
    {
        Node root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(50);  
        root.left.left = new Node(30);
        root.left.right = new Node(40);
        
        verticalSum(root, 0);
        for(Map.Entry sum: tm.entrySet())
            System.out.print(sum.getValue()+" ");
    }

    private static void verticalSum(Node root, int hd) {
        if(root == null) return;
        verticalSum(root.left, hd-1);
        int curr = tm.getOrDefault(hd, 0);
        tm.put(hd, curr+root.val);
        verticalSum(root.right, hd+1);
    }

    private static TreeMap<Integer, Integer> tm = new TreeMap<>();

    private static class Node {
        Node left;
        Node right;
        int val;
    
        public Node(int val) {
            this.val = val;
        }
    }
}

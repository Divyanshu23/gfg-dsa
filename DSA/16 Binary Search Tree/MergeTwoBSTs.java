import java.util.ArrayList;
import java.util.Stack;

public class MergeTwoBSTs {
    public static void main (String[] args) {
        var root1 = new Node(6);
        root1.left = new Node(3);
        root1.right = new Node(10);
        root1.left.left = new Node(1);
        root1.left.right = new Node(5);
        root1.right.left = new Node(8);

        var root2 = new Node(9);
        root2.left = new Node(7);
        root2.right = new Node(10);
        root2.left.left = new Node(4);
        root2.left.right = new Node(8);
        root2.right.right = new Node(12);
        var res = merge(root1, root2);
        for (var item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> merge(Node root1,Node root2)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        while (true) 
        { 
            if (root1 != null) 
            {
                s1.push(root1); 
                root1 = root1.left; 
            } 
            else if (root2 != null) 
            {
                s2.push(root2); 
                root2 = root2.left; 
            } 
            else if (!s1.isEmpty() && !s2.isEmpty()) 
            {
                root1 = s1.peek(); 
                root2 = s2.peek(); 
            
                if (root1.data <= root2.data) 
                {
                    res.add(root1.data);
                    s1.pop(); 
                    root1 = root1.right; 
                    root2 = null; 
                } 
                else if (root2.data < root1.data) 
                {
                    res.add(root2.data);
                    s2.pop(); 
                    root2 = root2.right; 
                    root1 = null; 
                } 
            } else if(!s1.isEmpty()) {
                root1 = s1.pop();
                res.add(root1.data);
                root1 = root1.right;
            } else if(!s2.isEmpty()) {
                root2 = s2.pop();
                res.add(root2.data);
                root2 = root2.right;
            }
            else break; 
        }
        return res;
    }

    private static class Node {
        Node left;
        Node right;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }   
}

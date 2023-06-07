import java.util.ArrayList;
import java.util.Stack;

public class IntersectionOfTwoBSTs {
    public static void main (String[] args) {
        Node root1 = new Node(5);
        Node root2 = new Node(10);

        var res = findIntersection(root1, root2);
        for (var item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static ArrayList<Integer> findIntersection(Node root1, Node root2)
    {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        while (true) {
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
            
                if (root1.data == root2.data) 
                { 
                    res.add(root1.data);
                    s1.pop(); 
                    s2.pop(); 
                
                    root1 = root1.right; 
                    root2 = root2.right; 
                } 
                else if (root1.data < root2.data) 
                {
                    s1.pop(); 
                    root1 = root1.right; 
                    root2 = null; 
                } 
                else if (root1.data > root2.data) 
                { 
                    s2.pop(); 
                    root2 = root2.right; 
                    root1 = null; 
                } 
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

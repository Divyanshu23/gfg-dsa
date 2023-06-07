import java.util.ArrayDeque;

public class AVLTree {
    public static void main(String args[]) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);
        System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
        traverse(root);
        System.out.println();
        root = delete(root, 20);
        System.out.println("After Deletion:");
        traverse(root);
        System.out.println();
    }

    public static boolean search(Node root, int x) {
        while (root != null) {
            if(x == root.data) return true;
            else if(x < root.data)
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }

    public static Node insert(Node root, int x) {
        Node parent = null;
        Node curr = root;
        var st = new ArrayDeque<Node>();

        while (curr != null) {
            parent = curr;
            st.push(parent);
            if(x == curr.data) return root;
            else if(x < curr.data)
                curr = curr.left;
            else 
                curr = curr.right;
        }

        if(parent == null) {
            return new Node(x);
        } else {
            if(x < parent.data) 
                parent.left = new Node(x);
            else 
                parent.right = new Node(x);
        }

        Node parentOfParent = null;
        int bf = 0;
        while (!st.isEmpty()) {
            parent = st.pop();
            parent.height = Math.max(getHeight(parent.left), getHeight(parent.right)) + 1;
            bf = getBalance(parent);
            if(bf > 1) {
                if(x < parent.left.data) {    // Left - Left Case
                    parent = rightRotate(parent);
                } else {                      // Left - Right Case
                    parent.left = leftRotate(parent.left);
                    parent = rightRotate(parent);
                }
                if(!st.isEmpty()) {
                    parentOfParent = st.peek();
                    if(x < parentOfParent.data) parentOfParent.left = parent;
                    else parentOfParent.right = parent;
                } else root = parent;
            } else if(bf < -1) {
                if(x > parent.right.data) {  // Right - Right Case
                    parent = leftRotate(parent);
                } else {                    // Right - Left Case
                    parent.right = rightRotate(parent.right);
                    parent = leftRotate(parent);
                }
                if(!st.isEmpty()) {
                    parentOfParent = st.peek();
                    if(x < parentOfParent.data) parentOfParent.left = parent;
                    else parentOfParent.right = parent;
                } else root = parent;
            }
        }
        
        return root;
    }

    public static Node delete(Node root, int x) {
        if(root == null)
            return root;

        if(x < root.data) 
            root.left = delete(root.left, x);
        else if(x > root.data)
            root.right = delete(root.right, x);
        else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null)
                return root.left;
            else {
                Node temp = getInorderSuccessor(root.right);
                root.data = temp.data;
                root.right = delete(root.right, root.data);
            }
        }

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        int bf = getBalance(root);
        if(bf > 1) {
            if(getBalance(root.left) >= 0)       // Left - Left Case
                return rightRotate(root);
            else {                               // Left - Right Case
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }
        } else if(bf < -1) {
            if(getBalance(root.right) <= 0)      // Right - Right Case
                return leftRotate(root);
            else {
                root.right = rightRotate(root.right);
                return leftRotate(root);         // Right - Left case
            }
        }
        return root;
    }

    private static Node getInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static Node leftRotate(Node root) {
        if(root == null) return null;
        Node newRoot = root.right;
        Node temp = newRoot.left;
        newRoot.left = root;
        root.right = temp;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right))+1;
        return newRoot;
    }

    private static Node rightRotate(Node root) {
        if(root == null) return null;
        Node newRoot = root.left;
        Node temp = newRoot.right;
        newRoot.right = root;
        root.left = temp;

        root.height = Math.max(getHeight(root.left), getHeight(root.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right))+1;
        return newRoot;
    }

    private static int getHeight(Node root) {
        if(root == null)
            return 0;
        return root.height;
    }

    private static int getBalance(Node root) {
        if(root == null)
            return 0;
        return getHeight(root.left) - getHeight(root.right);
    }

    private static void traverse(Node root) {
        if(root == null) return;
        traverse(root.left);
        System.out.print(root.data + " ");
        traverse(root.right);
    }

    

    private static class Node {
        Node left;
        Node right;
        int data;
        int height;
    
        public Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }
}

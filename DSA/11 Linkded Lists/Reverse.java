import java.util.Scanner;

public class Reverse {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traverse(head);

        head = iterativeReverse(head);
        traverse(head);
        head = recursiveReverse(head, null);
        traverse(head);
        sc.close();
    }

    private static Node iterativeReverse(Node head) {
        if(head == null || head.next == null) return head;
        Node next;
        Node prev = head;
        head = head.next;
        prev.next = null;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static Node recursiveReverse(Node head, Node prev) {
        if(head == null) return prev;
        Node next = head.next;
        head.next = prev;
        return recursiveReverse(next, head);
    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    private static class Node {
        Node next;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }
}

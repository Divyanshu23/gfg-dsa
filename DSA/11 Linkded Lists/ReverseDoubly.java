import java.util.Scanner;

public class ReverseDoubly {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.prev = head;
        head.next.next = new Node(30);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(40);
        head.next.next.next.prev = head.next.next;
        traverse(head);
        head = reverseDoubly(head);
        traverse(head);
        sc.close();
    }

    private static class Node {
        private int data;
        private Node next;
        private Node prev;
        private Node(int data) {
            this.data = data;
        }
    }
    public static Node reverseDoubly(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node curr  = head;

        while(curr != null) {
            curr.prev = curr.next;
            curr.next = prev;
            prev = curr;
            curr = curr.prev;
        }

        return prev;
    }

    public static void traverse(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
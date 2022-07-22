import java.util.Scanner;

public class RemoveDuplicatesFromSortedList {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(20);
        head.next.next.next = new Node(40);
        traverse(head);
        removeDuplicatesFromSortedList(head);
        traverse(head);
        sc.close();
    }

    private static void removeDuplicatesFromSortedList(Node head) {
        if(head == null || head.next == null) return;

        var prev = head;
        var curr = head.next;

        while (curr != null) {
            if(curr.data == prev.data) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
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

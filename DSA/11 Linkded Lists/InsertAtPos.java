import java.util.Scanner;

public class InsertAtPos {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traverse(head);
        
        int val = sc.nextInt();
        int pos = sc.nextInt();

        head = insertAtPos(head, pos, val);
        traverse(head);
        sc.close();
    }

    public static Node insertAtPos(Node head, int pos, int val) {

        if(pos == 1) {
            Node temp = new Node(val);
            temp.next = head;
            return temp;
        }

        if(head == null) return head;

        int count = 0;
        Node curr = head;
        while(count < (pos-2) && curr.next != null) {
            curr = curr.next;
            count++;
        }  

        if(curr == null)
            return head;

        if(count == (pos-2)) {
            Node temp = new Node(val);
            temp.next = curr.next;
            curr.next = temp;
        }
        return head;
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
        private int data;
        private Node next;
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

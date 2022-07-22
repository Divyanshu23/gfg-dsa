import java.util.Scanner;

public class SortedInsert {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traverse(head);

        int val = sc.nextInt();
        insertSorted(head, val);
        traverse(head);
        sc.close();
    }

    private static Node insertSorted(Node head, int val) {
        var temp = new Node(val);
        if(head == null) return temp;
        if(head.data >= val) {
            temp.next = head;
            return temp;
        }

        Node curr = head;
        while(curr.next != null && curr.next.data < val) {
            curr = curr.next;
        }

        temp.next = curr.next;
        curr.next = temp;

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
        }
    }
}
import java.util.Scanner;

public class SegregateEvenOdd {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        traverse(head);

        head = segregateEvenOdd(head);
        traverse(head);

        sc.close();
    }

    private static Node segregateEvenOdd(Node head) {
        Node evenS = null, evenE = null, oddS = null, oddE = null;

        if(head == null || head.next == null) return head;
        
        while (head != null) {
            if(head.data % 2 == 0) {
                if(evenE == null) {
                    evenS = head;
                    evenE = head;
                } else {
                    evenE.next = head;
                    evenE = head;
                }
                head = head.next;
                evenE.next = null;
            } else {
                if(oddE == null) {
                    oddS = head;
                    oddE = head;
                } else {
                    oddE.next = head;
                    oddE = head;
                }
                head = head.next;
                oddE.next = null;
            }
        }
        evenE.next = oddS;
        return evenS;
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

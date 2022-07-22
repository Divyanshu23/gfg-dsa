import java.util.Scanner;

public class NthFromEnd {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traverse(head);

        var n = sc.nextInt();
        nthFromEnd(head, n);

        sc.close();
    }

    private static void nthFromEnd(Node head, int n) {
        if(head == null) return;
        var first = head;
        
        for (int i = 0; i < n; i++) {
            if(first == null) return;
            first = first.next;
        }

        var second = head;

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println(second.data);
        return;
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

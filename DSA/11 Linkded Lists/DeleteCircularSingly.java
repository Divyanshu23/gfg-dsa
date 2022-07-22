import java.util.Scanner;

public class DeleteCircularSingly {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;
        
        traverseDoubly(head);
        int k = sc.nextInt();
        head = delete(head, k);
        traverseDoubly(head);
        sc.close();
    }

    private static Node delete(Node head, int pos) {
        if(pos == 1) {
            if(head == null || head.next == null) return null;
            swap(head, head.next);
            head.next = head.next.next;
            return head;
        }
        if(head == null) return head;

        Node curr = head;
        int currPos = 0;

        while (currPos < (pos-2) && curr.next != head) {
            curr = curr.next;
            currPos++;
        }
        if(currPos == (pos-2) && curr.next != head) {
            curr.next = curr.next.next;
        }
        return head;
    }

    private static void swap(Node head, Node headNext) {
        int temp = head.data;
        head.data = headNext.data;
        headNext.data = temp;
    }

    private static void traverseDoubly(Node head) {
        if(head == null) return;
        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

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

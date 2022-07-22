import java.util.Scanner;

public class FloydCycleDetection {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head.next;

        System.out.println(detectAndRemoveCycle(head));
        traverse(head);
    
        sc.close();
    }

    private static boolean detectAndRemoveCycle(Node head) {
        if(head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while((fast != null && fast.next != null) && slow != fast);
        if(fast == null || fast.next == null) return false;
        

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null;
        return true;
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
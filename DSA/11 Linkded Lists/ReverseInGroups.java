import java.util.Scanner;

public class ReverseInGroups {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traverse(head);

        int k = sc.nextInt();
        head = reverseInGroups(head, k);
        traverse(head);
        sc.close();
    }
    
    private static Node reverseInGroups(Node head, int k) {
        if(head == null) return head;
        boolean isFirstPass = true;
        Node prev = null;
        Node next = null;
        Node curr = head;
        Node startPrevPass = null, startCurrPass;

        int count;

        while (curr != null) {
            count = 0;
            prev = null;
            startCurrPass = curr;
            while (count < k && curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                ++count;
            }
            if(isFirstPass) {
                head = prev;
                isFirstPass = false;
                startPrevPass = startCurrPass;
            } else {
                startPrevPass.next = prev;
                startPrevPass = startCurrPass;
            }
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
        Node next;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }
}

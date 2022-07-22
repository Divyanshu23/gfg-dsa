public class PairwiseSwap {
    public static void main (String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        traverse(head);

        head = pairwiseSwap(head);
        traverse(head);
    }

    private static Node pairwiseSwap(Node head) {
        Node curr = head;
        Node prev = null;

        if(head == null || head.next == null) return head;
        head = head.next;

        while (curr != null && curr.next != null) {
            if(prev == null) {
                prev = curr.next;
                curr.next = curr.next.next;
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            } else {
                prev.next = curr.next;
                curr.next = curr.next.next;
                prev.next.next = curr;
                prev = curr;
                curr = curr.next;
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

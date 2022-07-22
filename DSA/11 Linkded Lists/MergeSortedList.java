public class MergeSortedList {
    public static void main (String[] args) {
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        Node head2 = new Node(5);
        head2.next = new Node(25);
        head2.next.next = new Node(28);
        head2.next.next.next = new Node(51);

        System.out.println("First List is: ");
        traverse(head1);
        System.out.println("Second list is: ");
        traverse(head2);

        head1 = merge(head1, head2);
        System.out.println("Merged List is: ");
        traverse(head1);
    }

    private static Node merge(Node head1, Node head2) {
        if(head1 == null || head2 == null) return head1;
        Node prev = null;
        Node next = head2.next;

        Node head = null;
        boolean first = true;

        while (head1 != null && head2 != null) {
            if(head1.data <= head2.data) {
                if(first) {
                    head = head1;
                    first = false;
                }
                prev = head1;
                head1 = head1.next;
            } else {
                if(first) {
                    head = head2;
                    first = false;
                }
                if(prev != null) prev.next = head2;
                head2.next = head1;
                prev = head2;
                head2 = next;
                if(next != null) next = next.next;
            }
        }

        if(head2 != null) {
            prev.next = head2;
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

public class Clone {
    public static void main (String[] args) {
        Node head = new Node(10); 
        head.next = new Node(5); 
        head.next.next = new Node(20); 
        head.next.next.next = new Node(15); 
        head.next.next.next.next = new Node(20); 
        
        head.random = head.next.next;
        head.next.random=head.next.next.next;
        head.next.next.random=head;
        head.next.next.next.random=head.next.next;
        head.next.next.next.next.random=head.next.next.next;
        traverse(head);

        Node head2 = clone(head);
        traverse(head2);
    }

    public static Node clone(Node head) {
        if(head == null) return head;
        Node curr = head;
        Node temp;

        while (curr != null) {
            temp = new Node(curr.data);
            temp.next = curr.next;
            curr.next = temp;
            curr = temp.next;
        }

        curr = head;
        while (curr != null) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
            curr = curr.next.next;
        }

        curr = head;
        temp = head.next;
        head = head.next;

        while (curr != null) {
            curr.next = temp.next;
            curr = curr.next;
            if(curr != null) {
                temp.next = curr.next;
                temp = curr.next;
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
        Node random;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }
}

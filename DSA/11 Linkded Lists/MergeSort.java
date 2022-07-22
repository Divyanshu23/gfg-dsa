import java.util.Scanner;

public class MergeSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node head = new Node(sc.nextInt());
        Node tail = head;
        while (n-- > 1) {
            tail.next = new Node(sc.nextInt());
            tail = tail.next;
        }

        head = mergeSort(head);
        traverse(head);
    
        sc.close();
    }

    private static Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;
        
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast == null) {
            Node curr = head;
            while(curr.next != slow) {
                curr = curr.next;
            }
            curr.next = null;
            
            head = mergeSort(head);
            slow = mergeSort(slow);
            
            return merge(head, slow);
        } else {
            Node curr = slow;
            slow = slow.next;
            curr.next = null;
            
            head = mergeSort(head);
            slow = mergeSort(slow);
            
            return merge(head, slow);
        }
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

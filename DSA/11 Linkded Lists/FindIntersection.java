import java.util.Scanner;

public class FindIntersection {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        Node head2 = new Node(5);
        head2.next = head1.next.next;
        var intersectionNode =  findIntersection(head1, head2);
        if(intersectionNode != null) {
            System.out.println("Intersection node is: " + intersectionNode.data);
        } else System.out.println("No intersection node");
    
        sc.close();
    }

    private static Node findIntersection(Node head1, Node head2) {
        if(head1 == null || head2 == null) return head1;
        int count1 = 0, count2 = 0;

        Node curr = head1;
        while (curr != null) {
            curr = curr.next;
            ++count1;
        }

        curr = head2;
        while (curr != null) {
            curr = curr.next;
            ++count2;
        }

        var temp = Math.abs(count1-count2);
        if(count1 >= count2) {
            curr = head1;
            for (int i = 0; i < temp; i++) {
                curr = curr.next;
            }
            head1 = curr;
        } else {
            curr = head2;
            for (int i = 0; i < temp; i++) {
                curr = curr.next;
            }
            head2 = curr;
        }

        while (head1 != null && head2!= null) {
            if(head1 == head2) return head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    private static class Node {
        Node next;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }
}

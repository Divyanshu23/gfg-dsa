public class PalindromeList {
    public static void main (String[] args) {
        Node head = new Node(1);
    	head.next = new Node(2);
    	head.next.next = new Node(2);
        head.next.next.next = new Node(1);

    	if(isPalindrome(head))
    	    System.out.println("Yes");
    	else
    	    System.out.println("No");
    }

    private static boolean isPalindrome(Node head){
        if(head==null)return true;
        Node slow=head,fast=head;
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node rev=reverseList(slow.next);
        Node curr=head;
        while(rev!=null){
            if(rev.data!=curr.data)
                return false;
            rev=rev.next;
            curr=curr.next;
        }
        return true;
    }

    private static Node reverseList(Node head){
        if(head==null||head.next==null)return head;
        Node rest_head=reverseList(head.next);
        Node rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }

    private static class Node {
        Node next;
        int data;
    
        public Node(int data) {
            this.data = data;
        }
    }
}

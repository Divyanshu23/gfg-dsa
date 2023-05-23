import java.util.Scanner;

public class ArrayImplementationDequeue {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();

        var q = new DeqeueUsingArray(cap);
        q.insertFront(10); 
		q.insertFront(20); 
		q.insertRear(30); 
		q.insertRear(40); 
    
        sc.close();
    }

    private static class DeqeueUsingArray {
        int[] arr;
        int cap;
        int size;
        int front;

        public DeqeueUsingArray(int cap) {
            this.cap = cap;
            front = 0;
            size = 0;
            arr = new int[cap];
        }

        public int getFront() {
            if(isEmpty())
                return -1;
            else {
                return front;
            }
        }

        public int getRear() {
            if(isEmpty())
                return -1;
            else
                return (front + size - 1)%cap;
        }

        public void insertFront(int val) {
            if(isFull()) return;
            
            front = (front-1+cap)%cap;
            arr[front] = val;
            ++size;
        }

        public int deleteFront() {
            if(isEmpty()) return Integer.MIN_VALUE;

            int item = arr[front];

            front = (front+1)%cap;
            size--;
            return item;
        }

        public void insertRear(int val) {
            if(isFull()) return;
            
            int rear = getRear();
            rear = (rear + 1)%cap;
            arr[rear] = val;
            ++size;
        }

        public int deleteRear() {
            if(isEmpty()) return Integer.MIN_VALUE;
            
            int rear = getRear();
            int item = arr[rear];

            size--;
            return item;
        }

        public boolean isFull() {
            return size == cap;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }
}

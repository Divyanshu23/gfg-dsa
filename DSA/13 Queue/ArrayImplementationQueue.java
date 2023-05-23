import java.util.Scanner;

public class ArrayImplementationQueue {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();

        var q = new QueueUsingArray(cap);
        q.enqueue(10); 
		q.enqueue(20); 
		q.enqueue(30); 
		q.enqueue(40); 

		System.out.println(q.dequeue() 
						+ " dequeued from queue"); 

		System.out.println("Front index is "
						+ q.getFront()); 

		System.out.println("Rear index is "
						+ q.getRear()); 
    
        sc.close();
    }

    private static class QueueUsingArray {
        int[] arr;
        int cap;
        int size;
        int front;

        public QueueUsingArray(int cap) {
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

        public void enqueue(int val) {
            if(isFull()) return;
            
            int rear = getRear();
            rear = (rear+1)%cap;
            arr[rear] = val;
            size++;
        }

        public int dequeue() {
            if(isEmpty()) return Integer.MIN_VALUE;

            int item = arr[front];

            front = (front+1)%cap;
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

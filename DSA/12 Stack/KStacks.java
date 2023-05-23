import java.util.Scanner;

public class KStacks {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt(); 

        var ks= new KStack(size, k); 
      
        ks.push(15, 2); 
        ks.push(45, 2); 
       
        ks.push(17, 1); 
        ks.push(49, 1); 
        ks.push(39, 1); 
       
        ks.push(11, 0); 
        ks.push(9, 0); 
        ks.push(7, 0); 
      
        System.out.println("Popped element from stack 2 is " + ks.pop(2) ); 
        System.out.println("Popped element from stack 1 is " + ks.pop(1) ); 
        System.out.println("Popped element from stack 0 is " + ks.pop(0) );
    
        sc.close();
    }

    private static class KStack {
        int[] arr;
        int[] next;
        int[] top;
        int freeTop;

        public KStack(int size, int k) {
            arr = new int[size];
            next = new int[size];
            for (int i = 0; i < next.length-1; i++) {
                next[i] = i+1;
            }
            next[next.length-1] = -1;
            top = new int[k];
            for (int i = 0; i < top.length; i++) {
                top[i] = -1;
            }
        }

        public void push(int val, int k) {
            if(isFull()) {
                System.out.println("Stack is Full");
                return;
            }
            
            arr[freeTop] = val;
            int i = freeTop;
            freeTop = next[freeTop];
            next[i] = top[k];
            top[k] = i;
        }

        public int pop(int k) {
            if(isEmpty(k)) {
                System.out.println("Stack is empty");
                return Integer.MAX_VALUE;
            }

            int i = top[k];
            top[k] = next[i];
            next[i] = freeTop;
            freeTop = i;
            return arr[i];
        } 

        private boolean isFull() {return freeTop == -1;}
        private boolean isEmpty(int k) {return top[k] == -1;}
    }
}

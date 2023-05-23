import java.util.Scanner;

public class TwoStacks {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        var twoStack = new TwoStack(size);
        twoStack.push1(5); 
        twoStack.push2(10); 
        twoStack.push2(15); 
        twoStack.push1(11); 
        twoStack.push2(7); 
        System.out.println("Popped element from stack1 is: " + twoStack.pop1()); 
        twoStack.push2(40); 
        System.out.println("Popped element from stack2 is: " + twoStack.pop2());
    
        sc.close();
    }

    private static class TwoStack {
        int[] arr;
        int size;

        int start1, start2;

        public TwoStack(int size) {
            arr = new int[size];
            this.size = size;
            start1 = -1;
            start2 = size;
        }

        public void push1(int val) {
            if(start2 - start1 > 1) {
                arr[++start1] = val;
            } else System.out.println("Stack is full");
        }

        public void push2(int val) {
            if(start2 - start1 > 1) {
                arr[--start2] = val;
            } else System.out.println("Stack is full");
        }

        public int pop1() {
            if(start1>=0) {
                int res = arr[start1];
                start1--;
                return res;
            } else {
                System.out.println("Stack is empty. Returning -1");
                return -1;
            }
        }

        public int pop2() {
            if(start2 < size) {
                int res = arr[start2];
                start2++;
                return res;
            } else {
                System.out.println("Stack is empty. Returning -1");
                return -1;
            }
        }
    }
}

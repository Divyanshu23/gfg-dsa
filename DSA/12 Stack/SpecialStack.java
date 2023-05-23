import java.util.ArrayDeque;

public class SpecialStack {
    public static void main (String[] args) {
        var s = new StackWithGetMin();;
        s.push(4);
        s.push(5);
        s.push(8);
        s.push(1);
        s.pop();
     
        System.out.println(" Minimum Element from Stack: " + s.getMin());

        var s1 = new StackWithGetMax();;
        s1.push(4);
        s1.push(5);
        s1.push(8);
        s1.push(1);
        s1.pop();

        System.out.println(" Maximum Element from Stack: " + s1.getMax());
    }

    private static class StackWithGetMin {
        ArrayDeque<Integer> s;
        int min;

        public StackWithGetMin() {
            s = new ArrayDeque<>();
            min = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if(s.isEmpty()) {
                s.push(val);
                min = val;
            } else if(val < min) {
                s.push(2*val - min);
                min = val;
            } else {
                s.push(val);
            }
        }

        public int pop() {
            if(s.isEmpty()) {
                System.out.println("Stack is Empty");
                return Integer.MAX_VALUE;
            }

            int val = s.pop();
            if(val < min) {
                int temp = min;
                min = 2*min - val;
                return temp;
            } else return val;
        }

        private int getMin() {
            if(s.isEmpty()) {
                System.out.println("Stack is empty");
                return Integer.MAX_VALUE;
             } else return min;
        }
    }

    private static class StackWithGetMax {
        ArrayDeque<Integer> s;
        int max;

        public StackWithGetMax() {
            s = new ArrayDeque<>();
            max = Integer.MIN_VALUE;
        }

        public void push(int val) {
            if(s.isEmpty()) {
                s.push(val);
                max = val;
            } else if(val > max) {
                s.push(2*val - max);
                max = val;
            } else {
                s.push(val);
            }
        }

        public int pop() {
            if(s.isEmpty()) {
                System.out.println("Stack is Empty");
                return Integer.MAX_VALUE;
            }

            int val = s.pop();
            if(val > max) {
                int temp = max;
                max = 2*max - val;
                return temp;
            } else return val;
        }

        private int getMax() {
            if(s.isEmpty()) {
                System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
             } else return max;
        }
    }

}

import java.util.ArrayDeque;
import java.util.Scanner;

public class StockSpan {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        getSpan(arr);
        sc.close();
    }

    public static void getSpan(int[] arr) {
        var s = new ArrayDeque<Integer>();
        s.push(0);
        System.out.print(1+" ");
        int idx;

        for(int i=1;i<arr.length;i++) {
            while (!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] > arr[i]) {
                    System.out.print(i-idx + " ");
                    s.push(i);
                    break;
                } else {
                    s.pop();
                }
            }
            if(s.isEmpty()) {
                System.out.print(i+1 + " ");
                s.push(i);
            }
        }
    }
}

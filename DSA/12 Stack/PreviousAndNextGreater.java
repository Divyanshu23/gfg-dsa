import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class PreviousAndNextGreater {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        var arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        previousGreater(arr);
        nextGreater(arr);
    
        sc.close();
    }

    private static void previousGreater(int[] arr) {
        var s = new ArrayDeque<Integer>();
        System.out.print(-1+" ");
        s.push(0);
        int idx;

        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] > arr[i]) {
                    System.out.print(arr[idx]+" ");
                    s.push(i);
                    break;
               } else {
                    s.pop();
               }
            }
            if(s.isEmpty()) {
                System.out.print(-1+" ");
                s.push(i);
            }
        }
        System.out.println();
    }

    private static void nextGreater(int[] arr) {
        var s = new ArrayDeque<Integer>();
        var res = new ArrayList<Integer>(arr.length);
        res.add(-1);
        s.push(arr.length-1);
        int idx;

        for (int i = arr.length-2; i >= 0; i--) {
            while (!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] > arr[i]) {
                    res.add(arr[idx]);
                    s.push(i);
                    break;
               } else {
                    s.pop();
               }
            }
            if(s.isEmpty()) {
                res.add(-1);
                s.push(i);
            }
        }

        for (int i = res.size()-1; i >= 0; i--) {
            System.out.print(res.get(i) + " ");
        }
        System.out.println();
    }
}

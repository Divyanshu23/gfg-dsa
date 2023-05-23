import java.util.ArrayDeque;
import java.util.Scanner;

public class MaxOfMinOfEveryWindow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        var arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        var out = maxOfMin(arr, arr.length);
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i]+" ");
        }
        System.out.println();
        sc.close();
    }

    public static int[] maxOfMin(int[] arr, int n) {
        var left = previousSmaller(arr,n);
        var right = nextSmaller(arr,n);
        
        var out = new int[n];
        int len;
        for(int i=0;i<n;i++) {
            len = right[i]-left[i]-1;
            out[len-1] = Math.max(out[len-1], arr[i]);
        }
        
        for(int i=n-2;i>=0;i--) {
            out[i] = Math.max(out[i], out[i+1]);
        }
        
        return out;
    }
    
    public static int[] previousSmaller(int[] arr, int n) {
        var res = new int[n];
        var s = new ArrayDeque<Integer>();
        s.push(0);
        res[0] = -1;
        
        int idx;
        
        for(int i=1;i<n;i++) {
            while(!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] < arr[i]) {
                    res[i] = idx;
                    s.push(i);
                    break;
                } else {
                    s.pop();
                }
            }
            if(s.isEmpty()) {
                res[i] = -1;
                s.push(i);
            }
        }
        return res;
    }
    
    public static int[] nextSmaller(int[] arr, int n) {
        var res = new int[n];
        var s = new ArrayDeque<Integer>();
        s.push(n-1);
        res[n-1] = n;
        
        int idx;
        
        for(int i=n-2;i>=0;i--) {
            while(!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] < arr[i]) {
                    res[i] = idx;
                    s.push(i);
                    break;
                } else {
                    s.pop();
                }
            }
            if(s.isEmpty()) {
                res[i] = n;
                s.push(i);
            }
        }
        return res;
    }
}

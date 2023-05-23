import java.util.ArrayDeque;
import java.util.Scanner;

public class LargestRectangularAreaHistogram {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxRectangularArea(arr));
        System.out.println(maxRectangularAreaEfficient(arr));
        sc.close();
    }

    private static int maxRectangularArea(int[] arr) {
        var ns = nextSmaller(arr);
        var ps = previousSmaller(arr);

        var res = Integer.MIN_VALUE;
        var curr = 0;

        for (int i = 0; i < ps.length; i++) {
            curr += arr[i];
            curr += (i - ps[i] - 1)*arr[i];
            curr += (ns[i] - i - 1)*arr[i];
            res = Integer.max(res, curr);
            curr = 0;
        }
        return res;
    }

    private static int[] previousSmaller(int[] arr) {
        var res = new int[arr.length];
        var s = new ArrayDeque<Integer>();
        s.push(0);
        res[0] = -1;
        int idx;

        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] < arr[i]) {
                    s.push(i);
                    res[i] = idx;
                    break;
                } else {
                    s.pop();
                }
            }
            if(s.isEmpty()) {
                s.push(i);
                res[i] = -1;
            }
        }
        return res;
    }

    private static int[] nextSmaller(int[] arr) {
        var res = new int[arr.length];
        var s = new ArrayDeque<Integer>();
        s.push(arr.length-1);
        res[arr.length-1] = arr.length;
        int idx;

        for (int i = arr.length-2; i >= 0; i--) {
            while (!s.isEmpty()) {
                idx = s.peek();
                if(arr[idx] < arr[i]) {
                    s.push(i);
                    res[i] = idx;
                    break;
                } else {
                    s.pop();
                }
            }
            if(s.isEmpty()) {
                s.push(i);
                res[i] = arr.length;
            }
        }
        return res;
    }

    private static int maxRectangularAreaEfficient(int[] arr) {
        var s = new ArrayDeque<Integer>();
        int curr = 0;
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[s.peek()] > arr[i]) {
                int idx = s.pop();
                curr = arr[idx]*(s.isEmpty() ? i:(i - s.peek() - 1));
                res = Math.max(res, curr);
            }
            s.push(i);
        }

        while (!s.isEmpty()) {
            int idx = s.pop();
            curr = arr[idx]*(s.isEmpty() ? arr.length : arr.length - s.peek()-1);
            res = Math.max(res, curr);
        }
        return res;
    }
}

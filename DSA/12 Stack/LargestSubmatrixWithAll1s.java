import java.util.ArrayDeque;
import java.util.Scanner;

public class LargestSubmatrixWithAll1s {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] mat = new int[m][n];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(largestSubmatrixWithAll1s(mat));
        sc.close();
    }

    private static int largestSubmatrixWithAll1s(int[][] mat) {
        int res = maxRectangularArea(mat[0]);
        for (int i = 1;i < mat.length;i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] != 0) mat[i][j] += mat[i-1][j];
            }
            res = Math.max(res, maxRectangularArea(mat[i]));
        }
        return res;
    }

    private static int maxRectangularArea(int[] arr) {
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

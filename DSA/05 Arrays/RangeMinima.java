import java.util.Scanner;

public class RangeMinima {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int l = sc.nextInt();
        int h = sc.nextInt();
        preProcess(arr, n);
        System.out.println(query(l, h));
        sc.close();
    }

    private static int[][] C;
    private static void preProcess(int[] arr, int n) {
        int cols = (int)(Math.log(n+1) / Math.log(2)) + 1;
        C = new int[n][cols];

        for(int j=0;j<cols;j++) {
            for(int i=0;(i+(1<<j)-1)<n;i++) {
                if(j == 0)
                    C[i][j] = arr[i];
                else {
                    C[i][j] = Math.min(C[i][j-1], C[i + (1 << (j-1))][j-1]);
                }
            }
        }
    }

    private static int query(int l, int h) {
        int len = h-l+1;
        int k = (int)(Math.log(len) / Math.log(2));

        return Math.min(C[l][k],C[h+1-(1<<k)][k]);
    }
}
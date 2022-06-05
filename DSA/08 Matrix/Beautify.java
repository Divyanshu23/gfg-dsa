import java.util.Scanner;

public class Beautify {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        var arr = new int[m][n];
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ops = beautify(arr);
        System.out.println("Number of Ops: " + ops);
        sc.close();
    }

    public static int beautify(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += arr[i][j];
            }
            maxSum = Math.max(maxSum, rowSum[i]);
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colSum[j] += arr[i][j];
            }
            maxSum = Math.max(maxSum, colSum[j]);
        }

        for(int i=0;i<m;i++) {
            rowSum[i] = maxSum - rowSum[i];
          }
      
          for(int j=0;j<n;j++) {
            colSum[j] = maxSum - colSum[j];
          }

        int j = 0, ops = 0;
        for (int i = 0; i < m; i++) {
            while (rowSum[i] > 0) {
                if(rowSum[i] > 0 && colSum[j] > 0) {
                    arr[i][j]++;
                    rowSum[i]--;
                    colSum[j]--;
                    ++ops;
                }
                ++j;
                if(j==n) j=0;
            }
        }
        return ops;
    }
}

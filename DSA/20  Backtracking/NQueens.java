import java.util.Scanner;

public class NQueens {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nQueens(n);
        sc.close();
    }

    private static void nQueens(int n) {
        int[][] res = new int[n][n];

        if(nQueensRec(n, res, 0)) {
            System.out.println("YES");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(res[i][j] + " ");
                }
                System.out.println();
            }
        } else 
            System.out.println("NO");
    }

    private static boolean nQueensRec(int n, int[][] res, int c) {
        if(c == n)
            return true; 
        
        for (int i = 0; i < n; i++) {
            if(isSafe(res, i, c, n)) {
                res[i][c] = 1;
                if(nQueensRec(n, res, c+1))
                    return true;
                res[i][c] = 0;
            }
        }
        
        return false;
    }

    private static boolean isSafe(int[][] res, int row, int col, int n) {
        for (int j = 0; j < col; j++) {
            if(res[row][j] == 1)
                return false;
        }

        for (int i = row-1,j=col-1; i>=0 && j>=0; i--,j--) {
            if(res[i][j] == 1)
                return false;
        }

        for (int i=row+1,j=col-1 ; i<n&&j>=0;i++,j--) {
            if(res[i][j] == 1)
                return false;
        }

        return true;
    }
}

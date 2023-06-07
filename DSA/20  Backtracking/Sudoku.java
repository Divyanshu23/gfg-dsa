public class Sudoku {
    public static void main (String[] args) {
        int[][] board = new int[][] { 
            { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 }, 
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 }, 
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };

        solve(board);
    }

    private static void solve(int[][] board) {
        int n = board.length;

        if(solveRec(board, 0, 0)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Given Sudoku can't be solved");
        }
    }

    private static boolean solveRec(int[][] board, int row, int col) {
        int n = board.length;
        int i=row,j;
        for(j=col;j<n;j++) {
            if(board[row][j] == 0)
                break;
        }
        if(j == n) {
            for(i = row+1; i < n; i++) {
                for (j = 0; j < n; j++) {
                    if(board[i][j] == 0) 
                        break;
                }
                if(j != n)
                    break;
            }
        }

        if(i == n && j == n)
            return true;

        for (int num = 1; num <= n; num++) {
            if(isSafe(board, i, j, num)) {
                board[i][j] = num;
                if(solveRec(board, i, j))
                    return true;
                board[i][j] = 0;
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col, int num) {
        int n = board.length;
        for (int k = 0; k < n; k++) {
            if(board[row][k] == num || board[k][col] == num)
                return false;
        }

        int s = (int)Math.sqrt(n);
        int rs = row - row%s;
        int cs = col - col%s;
        
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                if(board[rs+i][cs+j] == num)
                    return false;
            }
        }
        return true;
    }
}

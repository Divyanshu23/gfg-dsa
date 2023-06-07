public class PathInMaze {
    public static void main (String[] args) {
        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } };

        solveMaze(maze);
    }

    private static void solveMaze(int[][] maze) {
        int n = maze.length;
        int[][] res = new int[n][n];

        if(solveMazeRec(maze, res, 0, 0, n)) {
            for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(res[i][j] + " ");
                    }
                    System.out.println();
            }
        } else 
            System.out.println("Maze can't be solved");
    }

    private static boolean solveMazeRec(int[][] maze, int[][] res, int i, int j, int n) {
        res[i][j] = 1;
        if(i == n-1 && j == n-1)
            return true;

        if((j+1) < n && maze[i][j+1] == 1 && solveMazeRec(maze, res, i, j+1, n))
            return true;
        else if((i+1) < n && maze[i+1][j] == 1 && solveMazeRec(maze, res, i+1, j, n))
            return true;

        maze[i][j] = 0;
        return false;
    }
}
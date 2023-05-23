import java.util.ArrayDeque;
import java.util.Scanner;

public class Celebrity {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(celebrity(mat));
        sc.close();
    }

    private static int celebrity(int[][] mat) {
        var s = new ArrayDeque<Integer>();

        for (int i = 0; i < mat.length; i++) {
            s.push(i);
        }

        int a,b;
        while (s.size() > 1) {
            a = s.pop();
            b = s.pop();

            if(mat[a][b] == 1) {
                s.push(b);
            } else s.push(a);
        }
        if(s.isEmpty()) return -1;

        a = s.pop();
        int i = 0;
        while (i < mat.length) {
            if(i != a) {
                if(mat[a][i] != 0 || mat[i][a] != 1) return -1;
            }
        }

        return a;
    }
}

import java.util.Scanner;

public class Spiral {
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
        spiralTraversal(arr);
        sc.close();
    }

    public static void spiralTraversal(int[][] arr) {
        int rowStart = 0;
        int rowEnd = arr.length-1;
        int colStart = 0;
        int colEnd = arr[0].length-1;

        while(rowStart <= rowEnd && colStart <= colEnd) {
            boundaryTraversal(arr,rowStart, rowEnd, colStart, colEnd);
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
        }
    }

    public static void boundaryTraversal(int[][] arr, int rowStart, int rowEnd, int colStart, int colEnd) {

        if(rowStart == rowEnd) {
            for(int j=colStart;j<=colEnd;j++) {
                System.out.println(arr[rowStart][j]);
            }
            return;
        } else if(colStart == colEnd) {
            for(int i=rowStart;i<=rowEnd;i++) {
                System.out.println(arr[i][colStart]);
            }
            return;
        }

        for(int j=colStart;j<=colEnd;j++) {
            System.out.println(arr[rowStart][j]);
        }
      
        for(int i=rowStart+1;i<=rowEnd-1;i++) {
            System.out.println(arr[i][colEnd]);
        }
    
        for(int j=colEnd;j>=colStart;j--) {
            System.out.println(arr[rowEnd][j]);
        }
    
        for(int i=rowEnd-1;i>=rowStart+1;i--) {
            System.out.println(arr[i][colStart]);
        }
    }
}

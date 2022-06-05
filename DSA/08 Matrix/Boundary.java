import java.util.Scanner;

public class Boundary {
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
        boundary(arr);
        sc.close();
    }

    public static void boundary(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        if(m==1) {
            for(int j=0;j<n;j++) {
                System.out.println(arr[0][j]);
            }
            return;
        } else if(n==1) {
            for(int i=0;i<m;i++) {
                System.out.println(arr[i][0]);
            }
            return;
        }

        for(int j=0;j<n;j++) {
            System.out.println(arr[0][j]);
        }
      
        for(int i=1;i<m-1;i++) {
            System.out.println(arr[i][n-1]);
        }
    
        for(int j=n-1;j>=0;j--) {
            System.out.println(arr[m-1][j]);
        }
    
        for(int i=m-2;i>=1;i--) {
            System.out.println(arr[i][0]);
        }
    }
}
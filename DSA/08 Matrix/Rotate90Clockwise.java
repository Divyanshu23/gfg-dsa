import java.util.Scanner;

public class Rotate90Clockwise {
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

        rotate90Clockwise(arr);
        for (int[] row : arr) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    public static void rotate90Clockwise(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        transpose(arr);
        int low, high, temp;

        for (int j = 0; j < n; j++) {
            low = 0;
            high = m-1;
            while (low < high) {
                temp = arr[low][j];
                arr[low][j] = arr[high][j];
                arr[high][j] = temp;
                low++;
                high--;
            }
        }
    }

    public static void transpose(int[][] arr) {
        int m = arr.length;
        int temp;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
}

// Search in a martix sorted row wise and column wise

import java.util.Scanner;

public class Search {
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
        sc.close();
    }

    public static void search(int[][] arr, int k) {
        int m = arr.length;
        int n = arr[0].length;

        int i = 0, j = n-1;

        while (i < m && j >= 0) {
            if(arr[i][j] == k) {
                System.out.println("Found at (" + i + "," + j + ")");
                return;
            } else if(arr[i][j] < k) i++;
            else j--;
        }
        System.out.println("Not Found");
    }
}
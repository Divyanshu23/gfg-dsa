/*
Given an array of size n containing negative and positive, sort the array (infact segreagate) such that negatives
come first and then positves follow (>=0). Negatives and Positives can themselves be arranged in an order.
*/

import java.util.Scanner;

public class SortTwoTypes {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sortTwoTypes(arr);
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        sc.close();
    }
    
    public static void sortTwoTypes(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0) {
                j++;
                swap(arr,j,i);
            }
        }
        return;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FreqOfLimitedRange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        getFrequencies(arr, n, p);
        System.out.println(arr);
    }

    public static void getFrequencies(int[] arr, int n, int p) {
        int maxEle = p+1;
        if(maxEle == 0) maxEle++;


        for(int i=0;i<n;i++) {
            if(arr[i]%maxEle <= n) {
                arr[(arr[i]%maxEle)-1] += (1%maxEle)*maxEle;
            }
        }

        for(int i=0;i<n;i++) {
            arr[i] = arr[i]/maxEle;
        }
    }
}
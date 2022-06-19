/*
Given two arrays X and Y of positive integers, find the number of pairs
such that xy > yx (raised to power of) where x is an element from X and
y is an element from Y.
 */

import java.util.Arrays;
import java.util.Scanner;

public class NumberOfPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            x[i] = sc.nextInt();
        }

        int n = sc.nextInt();
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }

        System.out.println("Number of Pairs: " + countPairs(x,y,m,n));
        sc.close();
    }

    static long countPairs(int x[], int y[], int M, int N)
    {
        Arrays.sort(y);
        long count = 0;

        for(int i=0;i<x.length;i++) {
            if(x[i] == 0) continue;
            else if(x[i] == 1) {
                count += find(y, 0);
            } else if(x[i] == 2) {
                count += find(y,0) + find(y,1) + binarySearch(y, 5);
            } else if(x[i] == 3) {
                count += find(y,0) + find(y,1) + find(y,2) + binarySearch(y, x[i]+1);
            } else {
                count += find(y,0) + find(y,1) + binarySearch(y, x[i]+1);
            }
        }
        return count;
    }

    static long binarySearch(int y[], int k) {
        long l = lowerIndex(y, k);
        if(l == -1) return 0;
        else return y.length - l;
    }

    static long find(int y[], int k) {
        long low = lowerIndex(y,k);
        long high = higherIndex(y,k);

        if(low == -1) return 0;
        else return high - low + 1;
    }

    static long lowerIndex(int y[], int k) {
        int low = 0;int high = y.length-1;
        int mid;
        long ans = -1;

        while(low <= high) {
            mid = low + (high - low)/2;
            if(y[mid] == k) {
                ans = (long)mid;
                high = mid-1;
            } else if(k < y[mid]) high = mid-1;
            else low = mid+1;
        }
        return ans;
    }

    static long higherIndex(int y[], int k) {
        int low = 0;int high = y.length-1;
        int mid;
        long ans = -1;

        while(low <= high) {
            mid = low + (high - low)/2;
            if(y[mid] == k) {
                ans = (long)mid;
                low = mid+1;
            } else if(k < y[mid]) high = mid-1;
            else low = mid+1;
        }
        return ans;
    }
}

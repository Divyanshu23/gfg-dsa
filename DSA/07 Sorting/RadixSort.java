// Used when the range is large (may be n^2 or even large but the span of element is still linear)
// Uses counting sort for each digit position
// T.C 0(d*(N+b)) where d is the no of digits, b is the base used.
// A.S.C 0(N+b)
// When a larger base is used, d decreases. Trade Off between space and time

import java.util.Scanner;

public class RadixSort {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        radixSort(arr);
        for (int item : arr) {
            System.out.print(item+" ");
        }
        System.out.println();
        sc.close();
    }

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int maxDigitCount = (int)Math.log10(max)+1;

        for (int i = 0; i < maxDigitCount; i++) {
            countingSortVariant(arr, i);
        }
    }

    public static void countingSortVariant(int[] arr, int k) {
        int[] digitArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            digitArray[i] = extractDigit(arr[i], k);
        }

        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[digitArray[i]]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        int[] out = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--) {
            out[count[digitArray[i]]-1] = arr[i];
            count[digitArray[i]]--;
        }

        for (int i = 0; i < out.length; i++) {
            arr[i] = out[i];
        }
    }

    public static int extractDigit(int n, int k) {
        int numOfDigits = (int)Math.log10(n) + 1;
        if(numOfDigits < k+1) return 0;

        for (int i = 0; i < k; i++) {
            n = n/10;
        }

        return n%10;
    }
}

import java.util.Scanner;

public class Inversrions {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countInversions(arr, 0, arr.length-1));
        sc.close();
    }

    public static int countInversions(int[] arr, int l, int h) {
        if(l < h) {
            int m = l + (h-l)/2;
            int count = countInversions(arr, l, m) + countInversions(arr, m+1, h);
            return count + merge(arr, l, m, h);
        }
        return 0;
    }

    public static int merge(int[] arr, int l, int m, int h) {
        int count = 0;
        int max = (arr[m] >= arr[h] ? arr[m]:arr[h]) + 1;
        if(max == 0) max++;

        int i = l, j = m+1, k = l;

        while (i <= m && j <= h) {
            if(arr[i]%max <= arr[j]%max) {
                arr[k] += (arr[i]%max)*max;
                ++k;
                ++i;
            } else {
                arr[k] += (arr[j]%max)*max;
                ++k;
                ++j;
                count += m-i+1;
            }
        }

        while (i <= m) {
            arr[k] += (arr[i]%max)*max;
            k++;
            i++;
        }

        while (j <= h) {
            arr[k] += (arr[j]%max)*max;
            k++;
            j++;
        }

        for (int t = l; t <= h; t++) {
            arr[t] = arr[t]/max;
        }
        return count;
    }
}

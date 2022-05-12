import java.util.Scanner;

public class MedianSortedArrays {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Median: " + getMedian(arr1, arr2));

        sc.close();
    }

    public static double getMedian(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int low, high, i1,i2;
        int max1, min1, max2, min2;

        if(n1 <= n2) {
            low = 0; high = n1;
            while (low <= high) {
                i1 = low + (high - low) / 2;
                i2 = (n1+n2+1)/2 - i1;

                max1 = i1 == 0 ? Integer.MIN_VALUE : arr1[i1-1];
                min1 = i1 == n1 ? Integer.MAX_VALUE : arr1[i1];
                max2 = i2 == 0 ? Integer.MIN_VALUE : arr2[i2-1];
                min2 = i2 == n2 ? Integer.MAX_VALUE : arr2[i2];

                if(max1 <= min2 && max2 <= min1) {
                    if((n1 + n2)%2 == 0) return (Math.max(max1, max2) + Math.min(min1, min2))/2;
                    else return Math.max(max1, max2);
                } else if(max1 > min2) high =  i1-1;
                else low = i1+1;   
            }
            return -1;
        } else {
            low = 0; high = n2;
            while(low <= high) {
                i2 = low + (high - low) / 2;
                i1 = (n1+n2+1)/2 - i2;

                max1 = i1 == 0 ? Integer.MIN_VALUE : arr1[i1-1];
                min1 = i1 == n1 ? Integer.MAX_VALUE : arr1[i1];
                max2 = i2 == 0 ? Integer.MIN_VALUE : arr2[i2-1];
                min2 = i2 == n2 ? Integer.MAX_VALUE : arr2[i2];

                if(max1 <= min2 && max2 <= min1) {
                    if((n1 + n2)%2 == 0) return (Math.max(max1, max2) + Math.min(min1, min2))/2;
                    else return Math.max(max1, max2);
                } else if(max1 > min2) high =  i2-1;
                else low = i2+1;
            }
            return -1;
        }
    }
}

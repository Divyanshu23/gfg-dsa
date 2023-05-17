import java.util.Scanner;

public class MaximumIndex {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getMaxIndexDifference(arr));
        sc.close();
    }

    public static int getMaxIndexDifference(int[] arr) {
        int n = arr.length;
        int[] lMin = new int[n];
        lMin[0] = arr[0];

        for (int i = 1; i < n; i++) {
            lMin[i] = Math.min(lMin[i-1], arr[i]);
        }

        int[] rMax = new int[n];
        rMax[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i+1], arr[i]);
        }

        int i=0, j=0, maxIndxDiff = 0;

        while (i < n && j < n) {
            if(rMax[j] >= lMin[i]) {
                maxIndxDiff = Math.max(maxIndxDiff, j-i);
                j++;
            } else 
                i++;
        }
        return maxIndxDiff;
    }
}

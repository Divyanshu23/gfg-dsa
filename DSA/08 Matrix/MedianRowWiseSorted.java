import java.util.Scanner;

public class MedianRowWiseSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        var arr = new int[m][n];
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(median(arr));
        sc.close();
    }

    private static int bSearch(int[] arr, int key) {
        int l = 0;
        int h = arr.length - 1;
        int mid;
        int ans = 0;

        while (l <= h) {
            mid = l + (h - l) / 2;
            if (arr[mid] >= key) {
                h = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[ans] == key)
            return ans;
        else if (key < arr[0])
            return -1;
        else if (key > arr[arr.length - 1])
            return -(arr.length + 1);
        else
            return -(ans + 1);
    }

    private static int median(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int min = mat[0][0];
        int max = mat[0][c - 1];

        for (int i = 1; i < r; i++) {
            min = Math.min(min, mat[i][0]);
            max = Math.max(max, mat[i][c - 1]);
        }

        int medPos = (r * c + 1) / 2;
        int mid, midPos, pos;

        while (min < max - 1) {
            mid = min + (max - min) / 2;
            midPos = 0;
            pos = 0;
            for (int i = 0; i < r; i++) {
                pos = bSearch(mat[i], mid);
                if (pos >= 0)
                    midPos += pos;
                else
                    midPos += Math.abs(pos + 1);
            }

            if (midPos == medPos) {
                max = mid - 1;
            } else if (midPos < medPos) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        midPos = 0;
        pos = 0;
        for (int i = 0; i < r; i++) {
            pos = bSearch(mat[i], max);
            if (pos >= 0)
                midPos += pos;
            else
                midPos += Math.abs(pos + 1);
        }
        if (midPos >= medPos)
            return min;
        else
            return max;
    }
}
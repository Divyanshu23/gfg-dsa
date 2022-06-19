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

    public static int median(int[][] arr) {
        int r = arr.length;
        int c = arr[0].length;

        int min = mat[0][0], max = mat[0][c-1];
        for (int i=1; i<r; i++)
        {
            if (mat[i][0] < min)
                min = mat[i][0];

            if (mat[i][c-1] > max)
                max = mat[i][c-1];
        }

        int medPos = (r * c + 1) / 2;
        while (min < max)
        {
            int mid = (min + max) / 2;
            int midPos = 0;
            int pos = 0;
            for (int i = 0; i < r; ++i){
                pos = Arrays.binarySearch(mat[i],mid);

                if(pos < 0)
                    pos = Math.abs(pos) - 1;
                else
                {
                    while(pos < mat[i].length && mat[i][pos] == mid)
                        pos += 1;
                }

                midPos = midPos + pos;
            }
            if (midPos < medPos)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }
}
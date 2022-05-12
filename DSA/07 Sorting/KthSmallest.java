import java.util.Scanner;

public class KthSmallest {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(kthSmallest(arr, k));
        sc.close();
    }

    public static int kthSmallest(int[] arr, int k) {
        int l = 0, h = arr.length-1;
        while (l <= h) {
            int p = lomutoPartition(arr, l, h);
            if(p == k-1) return arr[p];
            else if(p < k-1) l = p+1;
            else h = p-1;
        }

        return -1;
    }

    public static int lomutoPartition(int[] arr, int l, int h) {
        int i = l-1;
        for (int j = l; j <= h-1.; j++) {
            if(arr[j] < arr[h]) {
                ++i;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

import java.util.Scanner;

public class Partition {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Before Partition:");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();

        int p = lomutoPartition(arr, 0, arr.length-1);
        System.out.println("After Partition:");
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
        sc.close();
    }

    public static int naivePartition(int[] arr, int l, int h) {
        // Naive Partition fixes the pivot at its correct position. It return the index of pivot.
        // All the elements before pivot index are <= pivot and all the elements afer pivot index are > than pivot.
        // Stable Partitioning Alog. Multiple Passes of arr. Requires a Temp array.
        var temp = new int[h-l+1];
        int indx = 0;
        int p = h;

        for (int i = l; i <= h; i++) {
            if(arr[i] < arr[p]) temp[indx++] = arr[i];
        }

        for (int i = l; i <= h; i++) {
            if(arr[i] == arr[p]) temp[indx++] = arr[i];
        }
        int res = l + indx - 1;

        for (int i = l; i <= h; i++) {
            if(arr[i] > arr[p]) temp[indx++] = arr[i];
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }

        return res;
    }

    public static int lomutoPartition(int[] arr, int l, int h) {
        // Lomuto Partition fixes the pivot at its correct position. It return the index of pivot.
        // All the elements before pivot index are < pivot and all the elements afer pivot index are >= than pivot.
        // Unstable Partitioning Alog. Single Pass. No temp array.
        int i = l-1;
        for (int j = l; j <= h-1; j++) {
            if(arr[j] < arr[h]) {
                ++i;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, h);
        return i+1;
    }

    public static int hoarePartition(int[] arr, int l, int h) {
        //  Hoare's Partition does not fixes the pivot at the correct position.
        //  It return an index j such that all the elements <= j are <= pivot and all the elements after j are >= than pivot.
        // Unstable Partitioning Alog. Single Pass. No temp array.
        int i = l-1;
        int j = h+1;
        int ele = arr[l];

        while (true) {
            do {
                i++;
            } while(arr[i] < ele);

            do {
                j--;
            } while (arr[j] > ele);

            if(i >= j) return j;
            swap(arr, i, j);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
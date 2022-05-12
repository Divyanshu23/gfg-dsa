import java.util.Scanner;

public class SmallestPositiveMissing {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int segregate(int[] arr) {
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                swap(arr, i, end);
                end++;
            }
        }
        return end;
    }

    public static int getSmallestMissingPositive(int[] arr) {
        int size = segregate(arr);

        for (int i = 0; i < size; i++) {
            if(Math.abs(arr[i]) <= size && arr[Math.abs(arr[i])-1] > 0) {
                arr[Math.abs(arr[i]) -1] *= -1;
            }
        }

        for (int i = 0; i < size; i++) {
            if(arr[i] > 0) return i+1;
        }
        return size+1;
    }
}

import java.util.Scanner;

public class OneOddOccuring {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(findOddOccuring(arr, size));
        sc.close();
    }

    public static int findOddOccuring(int[] arr, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = res^arr[i];
        }
        return res;
    }
}
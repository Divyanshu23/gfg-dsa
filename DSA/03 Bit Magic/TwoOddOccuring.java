import java.util.Scanner;

public class TwoOddOccuring {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = findTwoOddOccuring(arr, size);
        for (int i : res) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    public static int[] findTwoOddOccuring(int[] arr, int n) {
        int res[] = new int[]{0,0};
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp = temp ^ arr[i];
        }

        int k = temp & -temp;   // or temp = temp & ~(temp-1)
        for (int i = 0; i < n; i++) {
            if((k & arr[i]) == 1) {
                res[0] = res[0]^arr[i];
            } else res[1] = res[1]^arr[i];
        }
        return res;
    }
}

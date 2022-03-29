import java.util.Scanner;

public class MaxAND {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxAND(arr,n));
        sc.close();
    }

    public static int maxAND(int[] arr, int n) {
        int res = 0;
        int temp, count;

        for(int i=31;i>=0;i--) {
            temp = res | (1<<i);
            count = 0;
            for(int j=0;j<n;j++) {
                if((temp & arr[j]) == temp) ++count;
                if(count >= 2) res = temp;
            }
        }
        return res;
    }
}
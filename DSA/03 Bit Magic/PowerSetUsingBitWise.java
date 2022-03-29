import java.util.Scanner;

public class PowerSetUsingBitWise {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        System.out.println("Power Set is:");
        generatePowerSet(arr, n);
        sc.close();
    }

    public static void generatePowerSet(char[] arr, int n) {
        int bound = 1<<n;
        for (int i = 0; i < bound; i++) {
            for (int j = 0; j < n; j++) {
                if((i & (1<<j)) != 0) System.out.print(arr[j]);
            }
            System.out.print("\n");
        }
    }
}
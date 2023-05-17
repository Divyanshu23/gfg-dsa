import java.util.Scanner;

public class Rearrange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Array before rearragnement: ");
        for (int item : arr) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println();

        rearrange(arr);
        System.out.println("Array after rearragnement: ");
        for (int item : arr) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println();
        sc.close();
    }

    public static void rearrange(int[] arr) {
        int min_ind = 0;
        int max_ind = arr.length - 1;
        int element = arr[max_ind] + 1;
        
        if(element == 0) element += 1;

        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0) {
                arr[i] += (arr[max_ind] % element)*element;
                max_ind--;
            } else {
                arr[i] += (arr[min_ind] % element)*element;
                min_ind++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]/element;
        }
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Reverse {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        reverse(arr);
        System.out.println(arr);
        sc.close();
    }

    public static void reverse(ArrayList<Integer> arr) {
        int temp;
        int i = 0, j = arr.size() - 1;
        while(i < j) {
            temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
    }
}
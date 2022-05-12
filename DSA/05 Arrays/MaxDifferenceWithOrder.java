import java.util.ArrayList;
import java.util.Scanner;

public class MaxDifferenceWithOrder {
    public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>(n);
            for (int i = 0; i < n; i++) {
                arr.set(i, sc.nextInt());
            }
            System.out.println(maxDifferenceWithOrder(arr));
            sc.close();
    }

    public static int maxDifferenceWithOrder(ArrayList<Integer> arr) {
        int min = arr.get(0);
        int maxDiff = arr.get(1) - arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            maxDiff =  Math.max(maxDiff, arr.get(i) - min);
            min = Math.min(arr.get(i), min);
        }
        return maxDiff;
    }
}
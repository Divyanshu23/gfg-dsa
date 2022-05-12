import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FreqOfLimitedRange {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        sc.close();
        getFrequencies(arr, n);
        System.out.println(arr);
    }

    public static void getFrequencies(ArrayList<Integer> arr, int n) {
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i)-1);
        }

        Collections.sort(arr);

        int begin = n;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i) >= n) {
                arr.set(i, 0);
                if(begin == n) begin = i;
            }
        }

        for (int i = 0; i < begin; i++) {
            arr.set(arr.get(i) % n, arr.get(arr.get(i) % n) + n );
        }

        for (int i = 0; i < n; i++) {
            arr.set(i, arr.get(i) / n);
        }

        return;
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DistinctEveryWindow {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        var res = distinctEveryWindow(arr, k);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(i + " : " + res.get(i));
        }
        sc.close();
    }

    private static ArrayList<Integer> distinctEveryWindow(int[] arr, int k) {
        var hm = new HashMap<Integer, Integer>();
        var res = new ArrayList<Integer>(arr.length - k + 1);

        for (int i = 0; i < k; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
        }
        res.add(hm.size());

        for (int i = k; i < arr.length; i++) {
            hm.put(arr[i-k], hm.getOrDefault(arr[i-k],0)-1);

            if(hm.get(arr[i-k]) == 0) hm.remove(arr[i-k]);

            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            res.add(hm.size());
        }
        return res;
    }
}

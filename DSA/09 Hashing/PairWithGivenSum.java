import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class PairWithGivenSum {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        System.out.println(pairWithGivenSum(arr, sum));
        System.out.println(getPairsCount(arr, sum));
        sc.close();
    }

    private static boolean pairWithGivenSum(int[] arr, int sum) {
        var hs = new HashSet<>(arr.length);

        for (var item : arr) {
            if(hs.contains(sum - item)) return true;
            hs.add(item);
        }
        return false;
    }

    private static int getPairsCount(int[] arr, int sum) {
        var hm = new HashMap<Integer, Integer>(arr.length);
        int count = 0;
        
        for(var item: arr) {
            count += hm.getOrDefault(sum - item, 0);
            hm.put(item, hm.getOrDefault(item, 0)+1);
        }
        
        return count;
    }
}

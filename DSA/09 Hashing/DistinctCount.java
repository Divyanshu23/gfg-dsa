import java.util.HashMap;
import java.util.Scanner;

public class DistinctCount {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        var arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        countDistinct(arr,k);
        sc.close();
    }

    private static void countDistinct(int[] arr, int k) {
        var hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            hm.put(arr[i], i);
        }
        System.out.println(hm.size());

        for (int i = k; i < arr.length;i++) {
            if(hm.get(arr[i-k]) == (i-k)) hm.remove(arr[i-k]);
            hm.put(arr[i], i);
            System.out.println(hm.size());
        }
    }
}

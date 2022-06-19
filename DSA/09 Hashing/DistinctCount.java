import java.util.HashSet;
import java.util.Scanner;

public class DistinctCount {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        var arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(countDistinct(arr));
        sc.close();
    }

    private static int countDistinct(int[] arr) {
        var hs = new HashSet<Integer>(arr.length);

        for (Integer i : arr) {
            hs.add(i);
        }

        return hs.size();
    }
}

import java.util.HashSet;
import java.util.Scanner;

public class IntersectionUnsorted {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        var arr1 = new int[m];
        var arr2 = new int[n];

        for(int i=0;i<m;i++) {
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++) {
            arr2[i] = sc.nextInt();
        }
        System.out.println(countDistinctIntersection(arr1, arr2));
        sc.close();
    }

    private static int countDistinctIntersection(int[] arr1, int[] arr2) {
        var hs = new HashSet<Integer>();
        for (var item : arr1) {
            hs.add(item);
        }
        
        int res = 0;
        for (var item : arr2) {
            if(hs.contains(item)) {
                res++;
                hs.remove(item);
            }
        }
        return res;
    }
}

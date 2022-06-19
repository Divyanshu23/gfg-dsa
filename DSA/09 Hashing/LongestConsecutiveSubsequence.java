import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(longestCommonSubsequence(arr));
        sc.close();
    }

    private static int longestCommonSubsequence(int[] arr) {
        var hs = new HashSet<Integer>();
        for (var item : arr) {
            hs.add(item);
        }

        int curr;
        int res = 0;
        for (var item : hs) {
            if(!hs.contains(item-1)) {
                curr = 1;
                while (hs.contains(item+curr)) {
                    ++curr;
                }
                res = Math.max(res, curr);
            }
        }

        return res;
    }
}

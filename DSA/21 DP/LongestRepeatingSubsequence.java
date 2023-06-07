import java.util.Scanner;

public class LongestRepeatingSubsequence {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestRepeatingSubsequence(str));
        sc.close();
    }

    private static int longestRepeatingSubsequence(String str) {
        return getLCSLengthEfficient(str);
    }

    private static int getLCSLengthEfficient(String str1) {
        int m = str1.length();
        var dp = new int[2][m+1];

        boolean even = false;
        int i = 1;
        while(i <= m) {
            for (int j = 1; j <= m; j++) {
                if(even) {
                    if(str1.charAt(i-1) == str1.charAt(j-1) && i != j)
                        dp[0][j] = dp[1][j-1]+1;
                    else
                        dp[0][j] = Math.max(dp[0][j-1], dp[1][j]);
                } else {
                    if(str1.charAt(i-1) == str1.charAt(j-1) && i != j)
                        dp[1][j] = dp[0][j-1]+1;
                    else
                        dp[1][j] = Math.max(dp[1][j-1], dp[0][j]);
                }
            }
            i++;
            even = !even;
        }
        return dp[(++i)&1][m];
    }
}

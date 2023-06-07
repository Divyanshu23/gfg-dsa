import java.util.Scanner;

// Minimum insertions and deletions to convert str1 to str2

public class MinInsertionsDeletions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(minInsertionsDeletions(str1, str2));
        sc.close();
    }

    private static int minInsertionsDeletions(String str1, String str2) {
        int lcs = getLCSLengthEfficient(str1, str2);
        return str1.length() + str2.length() - 2*lcs; 
    }

    private static int getLCSLengthEfficient(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        var dp = new int[2][n + 1];

        boolean even = false;
        int i = 1;
        while (i <= m) {
            for (int j = 1; j <= n; j++) {
                if (even) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1))
                        dp[0][j] = dp[1][j - 1] + 1;
                    else
                        dp[0][j] = Math.max(dp[0][j - 1], dp[1][j]);
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1))
                        dp[1][j] = dp[0][j - 1] + 1;
                    else
                        dp[1][j] = Math.max(dp[1][j - 1], dp[0][j]);
                }
            }
            i++;
            even = !even;
        }
        return dp[(++i) & 1][n];
    }
}
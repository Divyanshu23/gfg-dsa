import java.util.Scanner;

public class PalindromeParitioning {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var str = sc.next();
        System.out.println(palindromeParitioning(str));
        sc.close();
    }

    private static int palindromeParitioning(String str) {
        int n = str.length();
        var dp = new int[n][n];
        var isPalindrome = new boolean[n][n];
        for(int i=0;i<n;i++) {
            isPalindrome[i][i] = true;
        }

        int j;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i+len-1 < n; i++) {
                j = i+len-1;
                if(str.charAt(i) == str.charAt(j) && (len==2 || isPalindrome[i+1][j-1])) {
                    dp[i][j] = 0;
                    isPalindrome[i][j] = true;
                } else {
                    isPalindrome[i][j] = false;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], 1+dp[i][k]+dp[k+1][j]);
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}

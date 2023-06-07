import java.util.Scanner;

public class EditDistance {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(editDistance(str1, str2));
        sc.close();
    }

    private static int editDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        var dp = new int[m+1][n+1];
        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m][n];
    }
}

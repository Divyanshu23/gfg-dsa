import java.util.Scanner;
import java.util.TreeSet;

public class LCS {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(getLCSLength(str1, str2));
        System.out.println(getLCSLengthEfficient(str1, str2));
        System.out.println(printLCS(str1, str2));
        sc.close();
    }

    private static int getLCSLength(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        var dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        return dp[m][n];
    }

    private static int getLCSLengthEfficient(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        var dp = new int[2][n+1];

        boolean even = false;
        int i = 1;
        while(i <= m) {
            for (int j = 1; j <= n; j++) {
                if(even) {
                    if(str1.charAt(i-1) == str2.charAt(j-1))
                        dp[0][j] = dp[1][j-1]+1;
                    else
                        dp[0][j] = Math.max(dp[0][j-1], dp[1][j]);
                } else {
                    if(str1.charAt(i-1) == str2.charAt(j-1))
                        dp[1][j] = dp[0][j-1]+1;
                    else
                        dp[1][j] = Math.max(dp[1][j-1], dp[0][j]);
                }
            }
            i++;
            even = !even;
        }
        return dp[(++i)&1][n];
    }

    private static TreeSet<String> printLCS(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        var dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }

        var lcs = lcsRec(dp, m, n, str1, str2);
        return lcs;
    }

    private static TreeSet<String> lcsRec(int[][] dp, int i, int j, String str1, String str2) {
        var res = new TreeSet<String>();
        var lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i][j] == dp[i-1][j] && dp[i][j] == dp[i][j-1]) {
                    var res1 = lcsRec(dp, i-1, j, str1, str2);
                    res1.addAll(lcsRec(dp, i, j-1, str1, str2));
                    var endChars = lcs.reverse().toString();
                    for (var item : res1) {
                        res.add(item + endChars);
                    }
                    return res;
                } else if(dp[i][j] == dp[i-1][j]) i--;
                else j--;
            }
        }

        res.add(lcs.reverse().toString());
        return res;
    }
}

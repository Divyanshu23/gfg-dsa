import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class ShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(shortestCommonSupersequence(str1,str2));
        sc.close();
    }

    private static TreeSet<String> shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        var dp = new int[m+1][n+1];

        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        var res = scsRec(dp, m, n, str1, str2);
        return res;
    }

    private static TreeSet<String> scsRec(int[][] dp, int i, int j, String str1, String str2) {
        var res = new TreeSet<String>();
        var scs = new StringBuilder();

        while (i > 0 && j > 0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                scs.append(str1.charAt(i-1));
                i--;
                j--;
            } else {
                if(dp[i][j] == (1+dp[i-1][j]) && (1+dp[i][j] == dp[i][j-1])) {
                    var res1 = scsRec(dp, i-1, j, str1, str2);
                    var res2 = scsRec(dp, i, j-1, str1, str2);

                    var list = new ArrayList<String>(res1.size()+res2.size());
                    var iter = res1.iterator();
                    while (iter.hasNext()){
                        list.add(iter.next()+str1.charAt(i-1));
                        iter.remove();
                    }
                    for (var item : list) {
                        res1.add(item);
                    }
                    iter = res2.iterator();
                    list.clear();
                    while (iter.hasNext()){
                        list.add(iter.next()+str2.charAt(j-1));
                        iter.remove();
                    }
                    for (var item : list) {
                        res2.add(item);
                    }
                    res1.addAll(res2);
                    var endChars = scs.reverse().toString();
                    if(endChars.length() > 0) {
                        for (var item : res1) {
                            res.add(item + endChars);
                        }
                        return res;
                    } else return res1;
                } else if(dp[i][j] == (1+dp[i-1][j])) {
                    var res1 = scsRec(dp, i-1, j, str1, str2);

                    var list = new ArrayList<String>(res1.size());
                    var iter = res1.iterator();
                    while (iter.hasNext()){
                        list.add(iter.next()+str1.charAt(i-1));
                        iter.remove();
                    }
                    for (var item : list) {
                        res1.add(item);
                    }
                    var endChars = scs.reverse().toString();
                    if(endChars.length() > 0) {
                        for (var item : res1) {
                            res.add(item + endChars);
                        }
                        return res;
                    } else return res1;
                }
                else {
                    var res2 = scsRec(dp, i, j-1, str1, str2);

                    var list = new ArrayList<String>(res2.size());
                    var iter = res2.iterator();
                    while (iter.hasNext()){
                        list.add(iter.next()+str2.charAt(j-1));
                        iter.remove();
                    }
                    for (var item : list) {
                        res2.add(item);
                    }
                    var endChars = scs.reverse().toString();
                    if(endChars.length() > 0) {
                        for (var item : res2) {
                            res.add(item + endChars);
                        }
                        return res;
                    } else return res2;
                }
            }
        }

        if(i == 0) {
            while (j>0) {
                scs.append(str2.charAt(j-1));
                j--;
            }
        } else {
            while (i>0) {
                scs.append(str1.charAt(i-1));
                i--;
            }
        }

        res.add(scs.reverse().toString());
        return res;
    }
}

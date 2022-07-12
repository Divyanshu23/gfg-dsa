import java.util.Scanner;

public class PatternSearch {

    private static final int q = 101;
    private static final int d = 256;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String pat = sc.nextLine();

        searchPatternRabinKarp(text, pat);
    
        sc.close();
    }

    public static void searchPatternNaive(String text, String pat) {

        int m = text.length();
        int n = pat.length();

        int j;
        for (int start = 0; start <= m-n; start++) {
            for (j = 0; j < n; j++) {
                if(pat.charAt(j) != text.charAt(start + j)) 
                    break;
            }
            if(j == n)
                System.out.print(start + " ");
        }

        System.out.println();
    }

    public static void searchPatternNaiveDistinctElements(String text, String pat) {
        int m = text.length();
        int n = pat.length();

        int j;
        for (int start = 0; start <= m - n;) {
            for(j = 0; j < n; j++) {
                if(pat.charAt(j) != text.charAt(start+j))
                    break;
            }

            if(j == n)
                System.out.print(start + " ");

            if(j == 0) start++;
            else start += j;
        }

        System.out.println();
    }

    public static void searchPatternRabinKarp(String text, String pat) {
        int m = text.length();
        int n = pat.length();

        int h = powUnderModulo(d,n-1,q);

        int p = 0, t = 0;
        for (int i = 0; i < n; i++) {
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + text.charAt(i))%q;
        }
        
        int j;
        for (int start = 0; start <= (m-n); start++) {
            if(p == t) {
                for (j = 0; j < n; j++) {
                    if(pat.charAt(j) != text.charAt(start + j))
                        break;
                }
                if(j == n) System.out.print(start + " ");
            } 
            if (start < (m-n)){
                t = ((t - text.charAt(start)*h)*d + text.charAt(start + n))%q;
                if(t < 0) t = t+q;
            }
        }
        System.out.println();
    }

    public static void searchPatternKMP(String text, String pat) {
        int[] lps = getLPSArray(pat);
        int m = text.length();
        int n = pat.length();

        int i = 0, j = 0;
        while (i < m) {
            if(pat.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            } else {
                if(j == 0) ++i;
                else j = lps[j-1];
            }

            if(j == n) {
                System.out.println(i - j);
                j = lps[j-1]; 
            }
        }
    }

    private static int powUnderModulo(int d, int n, int modulo) {
        if(n == 0) return 1;
        int temp = powUnderModulo(d, n/2, modulo);
        temp = (temp*temp)%modulo;
        return (n%2 == 0) ? temp : (temp*d)%modulo;
    }

    private static int[] getLPSArray(String str) {
        var lps = new int[str.length()];
        lps[0] = 0;
        int len = 0, i = 1;
        
        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(len)) {
                lps[i] = ++len;
                i++;
            } else {
                if(len == 0) ++i;
                else len = lps[len-1];
            }
        }
        return lps;
    }
}

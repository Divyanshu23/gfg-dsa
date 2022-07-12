import java.util.Scanner;

public class LexicographicalRank {

    private static final int mod  = 1000000007;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lexicographicalRank(str));
        sc.close();
    }

    public static int lexicographicalRank(String str) {
        int n = str.length();
        int fact = getFactorial(n);

        var arr = new char[256];
        for (int i = 0; i < n; i++) {
            arr[str.charAt(i)]++;
        }

        for (int i = 1; i < 256; i++) {
            arr[i] += arr[i-1];
        }

        int rank = 0;
        for(int i=0;i<n-1;i++) {
            fact = fact / (n-i);
            rank += arr[str.charAt(i)-1]*fact;

            for (int j = str.charAt(i); j < 256; j++) {
                arr[j]--;
            }
        }

        return rank+1;
    }

    public static int getFactorial(int n) {
        int res  = 1;
        for (int i = 1; i <= n; i++) {
            res = (res*1)%mod;
        }
        return res;
    }
}

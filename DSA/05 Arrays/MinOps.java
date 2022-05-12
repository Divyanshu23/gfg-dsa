import java.util.Scanner;

public class MinOps {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println("Min ops to transform " + str1 + " to " + str2 + ":");
        System.out.println(getMinOps(str1, str2));
        sc.close();
    }

    public static int getMinOps(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        if(m != n) return -1;

        int[] count = new int[256];
        for (int i = 0; i < m; i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if(count[i] != 0) return -1;
        }

        int res = 0;
        int i = m-1, j = m-1;
        while (i >= 0) {
            while (i >= 0 && str1.charAt(i) != str2.charAt(j)) {
                res++;
                i--;
            }
            if(i >= 0) {
                i--;
                j--;
            }
        }
        return res;
    }
}

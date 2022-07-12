import java.util.Scanner;

public class Rotation {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(checkRotation(str1, str2));
        sc.close();
    }

    public static boolean checkRotation(String str1, String str2) {
        if(str1.length() != str2.length()) return false;
        return isSubstring(str2+str2,str1);
    }

    public static boolean isSubstring(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int i=0, j =0;
        while (i < m) {
            if(s1.charAt(i) == s2.charAt(j)) {
                ++i;
                ++j;
                while (i < m && j < n && s1.charAt(i) == s2.charAt(j)) {
                    ++i; ++j;
                }

                if(j == n) return true;
                else j = 0;
            } else ++i;
        }
        return false;
    }
}

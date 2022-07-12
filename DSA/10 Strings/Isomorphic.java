import java.util.Arrays;
import java.util.Scanner;

public class Isomorphic {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(isIsomorphic(str1, str2));
        sc.close();
    }

    public static boolean isIsomorphic(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        int[] map = new int[26];
        Arrays.fill(map, -1);
        boolean[] mapped = new boolean[26];

        for (int i = 0; i < str1.length(); i++) {
            if(map[str1.charAt(i) - 'a'] == -1) {
                if(mapped[str2.charAt(i)-'a']) return false;
                else {
                    map[str1.charAt(i) - 'a'] = str2.charAt(i);
                    mapped[str2.charAt(i) - 'a']  = true;
                }
            } else if(map[str1.charAt(i) - 'a'] != str2.charAt(i)) return false;
        }

        return true;
    }
}

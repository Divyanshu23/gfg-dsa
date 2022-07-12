import java.util.Scanner;

public class SubsequenceOfOther {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(subsequenceOfOther(s1, s2));
        sc.close();
    }

    public static boolean subsequenceOfOther(String s1, String s2) {
        int j = 0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(j)) ++j;
        }

        return j == s2.length();
    }
}

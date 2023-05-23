import java.util.Scanner;

public class AnagramSearch {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        System.out.println(searchAnagram(s1, s2));
    
        sc.close();
    }

    public static boolean searchAnagram(String text, String pat) {
        var CT = new char[26];
        var CP = new char[26];

        for (int i = 0; i < pat.length(); i++) {
            CT[text.charAt(i)-'a']++;
            CP[pat.charAt(i)-'a']++;
        }

        for (int i = pat.length(); i < text.length(); i++) {
            if(areSame(CT,CP)) return true;

            CT[text.charAt(i - pat.length())]--;
            CT[text.charAt(i)]++;
        }
        return false;
    }

    private static boolean areSame(char[] CT, char[] CP) {
        for(int i=0;i<CT.length;i++) {
            if(CT[i] != CP[i]) return false;
        }
        return true;
    }
}

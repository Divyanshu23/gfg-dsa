import java.util.Scanner;

public class SmallestWindow{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pat = sc.nextLine();

        System.out.println(smallestWindow(str, pat));
    
        sc.close();
    }

    public static String smallestWindow(String text, String pat) {
        int[] textCount = new int[26];
        int[] patCount = new int[26];

        for (int i = 0; i < pat.length(); i++) {
            patCount[pat.charAt(i)-'a']++;
        }
        int count = 0;
        int i;
        for (i = 0; i < text.length(); i++) {
            textCount[text.charAt(i) - 'a']++;
            if(textCount[text.charAt(i)-'a'] <= patCount[text.charAt(i)-'a']) ++count;
            if(count == pat.length()) break;
        }
        if(count != pat.length()) return "-1";

        int j=0;
        int s=j, e=i;
        while(true) {
            while(j <= i) {
                textCount[text.charAt(j)-'a']--;
                if(textCount[text.charAt(j)-'a'] < patCount[text.charAt(j)-'a']) {
                    if((i-j+1) < (e-s+1)) {
                        s = j;
                        e = i;
                    }
                    j++;
                    break;
                }
                j++;
            }
            i++;
            while(i < text.length()) {
                if(textCount[text.charAt(i)-'a'] < patCount[text.charAt(i)-'a']) {
                    textCount[text.charAt(i)-'a']++;
                    break;
                }
                textCount[text.charAt(i)-'a']++;
                i++;
            }
            if(i == text.length()) break;
        }
        return text.substring(s, e+1);
    }
}

import java.util.Scanner;

public class Palindrome {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(checkPalindrom(s, 0, s.length()-1));
        sc.close();
    }

    public static boolean checkPalindrom(String s, int start, int end) {
        if(start >= end) return true;
        return (s.charAt(start) == s.charAt(end) && checkPalindrom(s, start+1, end-1));
    } 
}

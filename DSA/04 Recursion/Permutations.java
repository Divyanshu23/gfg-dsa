import java.util.Scanner;

public class Permutations {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println("Permutations are:");
        permutations(s, 0);
        sc.close();
    }

    public static void permutations(String s, int start) {
        if(start == s.length()-1) {
            System.out.println(s);
            return;
        }
        for(int i=start;i<s.length();i++) {
            s = swap(s, start, i);
            permutations(s, start+1);
            s = swap(s, start, i);
        }
    }

    static String swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }
}

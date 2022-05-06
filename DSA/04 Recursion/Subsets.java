import java.util.Scanner;

public class Subsets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String curr = "";
        generateSubsets(s, curr, 0);
        sc.close();
    }

    public static void generateSubsets(String s, String curr, int start) {
        if(start >= s.length()) {
            System.out.println(curr);
            return;
        }
        generateSubsets(s, curr, start+1);
        generateSubsets(s, curr + s.charAt(start), start+1);
    }
}

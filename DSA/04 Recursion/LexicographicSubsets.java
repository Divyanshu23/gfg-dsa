import java.util.Scanner;
import java.util.ArrayList;

public class LexicographicSubsets {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        ArrayList<String> res = subsets(s, 0);
        for (String subset : res) {
            System.out.println(subset);
        }
        sc.close();
    }

    public static ArrayList<String> subsets(String s, int start) {
        ArrayList<String> res = new ArrayList<String>();
        if(start == s.length()-1) {
            res.add("");
            res.add(String.valueOf(s.charAt(start)));
            return res;
        }

        res = subsets(s, start+1);
        int n = res.size();
        res.add(1, String.valueOf(s.charAt(start)));

        int j=2;
        for(int i=2;j<2*n;i++) {
            res.add(i, String.valueOf(s.charAt(start)) + res.get(j));
            j+=2;
        }
        return res;
    }
}
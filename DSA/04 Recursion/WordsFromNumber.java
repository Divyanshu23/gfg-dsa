import java.util.Scanner;
import java.util.ArrayList;

public class WordsFromNumber {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<String> map = new ArrayList<String>();
        map.add("abc");
        map.add("def");
        map.add("ghi");
        map.add("jkl");
        map.add("mno");
        map.add("pqrs");
        map.add("tuv");
        map.add("wxyz");
        createWords(arr, n, map , 0, "");
        System.out.print("\n");
        sc.close();
    }

    public static void createWords(int[] arr, int n, ArrayList<String> map, int start, String curr) {
        if(start == n) {
            System.out.print(curr + " ");
            return;
        }

        String s = map.get(arr[start] - 2);

        for (int i = 0; i < s.length(); i++) {
            createWords(arr, n, map, start+1, curr + s.charAt(i));
        }
    }
}
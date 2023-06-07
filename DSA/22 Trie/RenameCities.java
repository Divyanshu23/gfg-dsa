import java.util.Scanner;

public class RenameCities {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] cities = {};
        var codes = generateCode(cities);
        for (int i = 0; i < n; i++) {
            System.out.println(cities[i]+" -> " + codes[i]);
        }
        sc.close();
    }

    private static String[] generateCode(String[] cities) {
        var root = new TrieNode();
        var codes = new String[cities.length];
        
        for(int i=0;i<cities.length;i++) {
            codes[i] = insertAndGetCode(cities[i], root);
        }
        return codes;
    }

    private static String insertAndGetCode(String str, TrieNode root) {
        var curr = root;
        var code = new StringBuilder();
        boolean generated = false;
        int n = str.length();
        for(int i=0;i<n;i++) {
            if(!generated && curr.child[str.charAt(i)-'a'] == null) {
                curr.child[str.charAt(i)-'a'] = new TrieNode();
                code.append(str.charAt(i));
                generated = true;
            } else if(!generated) {
                code.append(str.charAt(i));
            } else if(curr.child[str.charAt(i)-'a'] == null) {
                curr.child[str.charAt(i)-'a'] = new TrieNode();
            }
            curr = curr.child[str.charAt(i)-'a'];
        }
        curr.count+=1;
        if(!generated) {
            if(curr.count > 1) {
                code.append(" " + curr.count);
            }
            generated = true;
        }
        return code.toString();
    }

    private static class TrieNode {
        TrieNode[] child;
        int count;
    }
}
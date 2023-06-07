import java.util.Scanner;

public class Trie {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        sc.close();
        root = new TrieNode();
        insert("bad");
        System.out.println(search("bad"));
        System.out.println(search("badd"));
        delete(root, "bat", 0);
        System.out.println(search("bad"));
    }

    private static TrieNode root;
    private static void insert(String str) {
        int n = str.length();
        var curr = root;
        for (int i = 0; i < n; i++) {
            if(curr.child[str.charAt(i)-'a'] == null) {
                curr.child[str.charAt(i)-'a'] = new TrieNode();
            }
            curr = curr.child[str.charAt(i)-'a'];
        }
        curr.isEnd = true;
    }

    private static boolean search(String str) {
        int n = str.length();
        var curr = root;
        for (int i = 0; i < n; i++) {
            if(curr.child[str.charAt(i)-'a'] == null) {
                return false;
            }
            curr = curr.child[str.charAt(i)-'a'];
        }
        return curr.isEnd;
    }

    private static TrieNode delete(TrieNode root, String str, int i) {
        if(root == null)
            return null;
        if(i == str.length()) {
            root.isEnd = false;
            if(isEmpty(root))
                root = null;
            return root;
        }
        root.child[str.charAt(i)-'a'] = delete(root.child[str.charAt(i)-'a'], str, i+1);
        if(root.isEnd == false && isEmpty(root))
            root = null;
        return root;
    }

    private static boolean isEmpty(TrieNode root) {
        if(root == null)
            return true;
        for (int i = 0; i < 26; i++) {
            if(root.child[i] != null)
                return false;
        }
        return true;
    }

    private static class TrieNode {
        boolean isEnd;
        TrieNode[] child = new TrieNode[26];
    }
}

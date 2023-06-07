import java.util.PriorityQueue;

public class HuffmanCode {
    public static void main (String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        var codes = getHuffmanCodes(chars, freq);

        for (int i = 0; i < chars.length; i++) {
            System.out.println(codes[i].ch + ": " + codes[i].code);
        }
    }

    private static MyPair[] getHuffmanCodes(char[] chars, int[] freq) {
        int n = chars.length;
        var pq = new PriorityQueue<Node>(n);
        for (int i = 0; i < n; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        Node left = null;
        Node right = null;
        while (pq.size() > 1) {
            left = pq.poll();
            right = pq.poll();

            Node curr = new Node('$', left.freq + right.freq);
            curr.left = left;
            curr.right = right;
            pq.add(curr);
        }

        Node root = pq.poll();
        var res = new MyPair[n];
        traverse(root, res, "");
        return res;
    }

    private static int s = 0;
    private static void traverse(Node root, MyPair[] res, String code) {
        if(root.character != '$') {
            if(code == "")
                res[s++] = new MyPair(root.character, "0");
            else
                res[s++] = new MyPair(root.character, code);
            return;
        }
        traverse(root.left, res, code + "0");
        traverse(root.right, res, code + "1");
    }

    private static class MyPair {
        char ch;
        String code;

        public MyPair(char ch, String code) {
                this.ch = ch;
                this.code = code;
        }
    }

    private static class Node implements Comparable<Node> {
        char character;
        int freq;
        Node left;
        Node right;

        public Node(char character, int freq) {
            this.character = character;
            this.freq = freq;
            left = null;
            right = null;
        }

        @Override
        public int compareTo(Node o) {
            return this.freq-o.freq;
        }
    }
}

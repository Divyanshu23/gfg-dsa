import java.util.PriorityQueue;
import java.util.Scanner;

public class RearrangeCharacters {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String out = rearrange(str);
        for(int i=0;i<out.length();i++) {
            System.out.print(out.charAt(i));
        }
        System.out.println();
        sc.close();
    }

    private static String rearrange(String str) {
        var pq = new PriorityQueue<Doublet>();

        int[] count = new int[26];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i] > 0) 
                pq.add(new Doublet((char)(i + 'a'), count[i]));
        }

        String out = "";
        Doublet curr = null;
        Doublet prev = new Doublet('#', -1);
        while (!pq.isEmpty()) {
            curr = pq.poll();
            out = out + curr.getChar();
            curr.decreaseFreq();

            if(prev.getFreq() > 0)
                pq.add(prev);
            
            prev = curr;
        }
        return out;
    }


    private static class Doublet implements Comparable<Doublet> {
        private char ch;
        private int freq;

        public Doublet(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public void decreaseFreq() {
            if(freq > 0)
                freq--;
        } 

        public int getFreq() {
            return freq;
        }

        public char getChar() {
            return ch;
        }

        @Override
        public int compareTo(Doublet o) {
            return o.freq - this.freq;
        }
    }
}
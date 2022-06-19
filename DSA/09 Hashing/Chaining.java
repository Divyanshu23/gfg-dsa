import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Chaining {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Hash hm = new Hash(n);
        hm.add(15);
        hm.add(7);
        hm.add(20);
        hm.add(10);
        System.out.println(hm.search(10));
        hm.remove(15);
        System.out.println(hm.search(15));

        sc.close();
    }
}

class Hash {
    private int BUCKET;
    ArrayList<LinkedList<Integer> > list;

    public Hash(int bucket) {
        BUCKET = bucket;
        list = new ArrayList<LinkedList<Integer> >();
        for(int i=0;i<BUCKET;i++) {
            list.add(new LinkedList<Integer>());
        }
    }

    public int search(int key) {
        int pos = key%BUCKET;
        return list.get(pos).indexOf(key);
    }

    public void add(int key) {
        if(search(key) == -1) {
            int pos = key%BUCKET;
            list.get(pos).add(key);
        }
    }

    public void remove(int key) {
        int pos = key%BUCKET;
        list.get(pos).remove((Object)key);
    }
}
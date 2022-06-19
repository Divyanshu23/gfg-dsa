import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// For quadratic proving to work fine -> Seach each of the slot, alpha < 0.5 and m is prime
// For Double Hashing to work fine, m and h2 must be coprime

public class OpenAddressing {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();

        var hm = new DoubleHashing(n);
        hm.insert(6);
        hm.insert(5);
        System.out.println(hm.search(6));
        System.out.println(hm.delete(6));
        System.out.println(hm.search(6));
        sc.close();
    }
}

class DoubleHashing {
    int BUCKET;
    ArrayList<Integer> table;
    int currSize;

    public DoubleHashing(int size) {
        BUCKET = size;
        table = new ArrayList<>(Collections.nCopies(BUCKET, -1));    // -1 represents empty slot
        currSize = 0;
    }

    public boolean search(int key) {
        var probe = key%BUCKET;                          // First Hash Function
        var offset = (BUCKET-1) - key%(BUCKET-1);        // Second Hash Function
        var initial = probe;

        while (table.get(probe) != key && table.get(probe) != -1) {
            probe = (probe + offset)%BUCKET;
            if(probe == initial) return false;
        }
        if(table.get(probe) == key) return true;
        return false;
    }

    public boolean insert(int key) {
        if(isFull()) return false;

        var probe = key%BUCKET;
        var initial = probe;
        var offset = (BUCKET-1) - key%(BUCKET-1);

        while (table.get(probe) != key && table.get(probe) != -1 && table.get(probe) != -2) {
            probe = (probe + offset)%BUCKET;
            if(probe == initial) return false;
        }

        if(table.get(probe) == -1 || table.get(probe) == -2) {
            table.set(probe, key);
            currSize++;
            return true;
        } else return false;
    }
    
    public boolean delete(int key) {
        if(isEmpty()) return false;

        var probe = key%BUCKET;
        var initial = probe;
        var offset = (BUCKET-1) - key%(BUCKET-1);

        while(table.get(probe) != key && table.get(probe) != -1) {
            probe = (probe + offset)%BUCKET;
            if(probe == initial) return false;
        }

        if(table.get(probe) == key) {
            table.set(probe, -2);
            currSize--;
            return true;
        } else return false;
    }


    public boolean isEmpty() {
        return currSize == 0;
    }

    public boolean isFull() {
        return currSize == BUCKET;
    }
}
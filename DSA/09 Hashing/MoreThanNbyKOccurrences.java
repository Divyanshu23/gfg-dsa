import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MoreThanNbyKOccurrences {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        var res = moreThanNbyKOccurrences(arr, k);
        for (Integer integer : res) {
            System.out.println(integer);
        }
        sc.close();
    }

    private static ArrayList<Integer> moreThanNbyKOccurrences(int[] arr, int k) {
        var hm = new HashMap<Integer, Integer>(k-1);
        int n = arr.length;

        for (var item : arr) {
            if(hm.containsKey(item)) {
                hm.put(item, hm.get(item)+1);
            } else if(hm.size() < (k-1)) {
                hm.put(item, 1);
            } else {
                for (var kv : hm.entrySet()) {
                    hm.put(kv.getKey(), kv.getValue()-1);
                    if(hm.get(kv.getKey()) == 0) hm.remove(kv.getKey());
                }
            }
        }

        var res = new ArrayList<Integer>();
        int count = 0;
        for (var kv : hm.entrySet()) {
            for (int i = 0; i < n; i++) {
                if(arr[i] == kv.getKey()) ++count;
            }
            if(count > n/k) res.add(kv.getKey());
        }

        return res;
    }
}

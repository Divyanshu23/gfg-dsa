import java.util.HashMap;
import java.util.Scanner;

public class FrequenciesCount {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        countFrequencies(arr);
        sc.close();
    }

    private static void countFrequencies(int[] arr) {
        var hm = new HashMap<Integer, Integer>(arr.length);
        for (int item : arr) {
            hm.put(item, hm.getOrDefault(item, 0)+1);
        }

        for(var kv : hm.entrySet()) {
            System.out.println(kv.getKey() + " : " + kv.getValue());
        }
    }
}
